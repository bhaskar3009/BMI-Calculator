import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class BMIcalculator  extends Applet implements ActionListener,ItemListener {

	Label title,nameLabel,ageLabel,heightLabel,weightLabel,genderLabel;
	TextField nameField,ageField,heightField,weightField;
	CheckboxGroup genderChoice;
	Checkbox c1,c2;
	Button submit;
	TextArea details;
	Float ht,wt,bmi;
	int age;
	String bmiFinal;
	Image picture,pic;
	
	public void init()
	{
		setBackground(Color.cyan);
		setLayout(null);
		setFont(new Font("Times new roman", Font.BOLD,16));

		title=new Label("BMI Calculator");
		title.setBounds(350,20,200,50);
		Font myFont = new Font("Serif",Font.BOLD,28);
 		title.setFont(myFont);
		add(title);
		nameLabel = new Label("Name: ");
		nameLabel.setBounds(20,100,140,50);
		ageLabel = new Label("Age:");
		ageLabel.setBounds(20,160,140,50);
		genderLabel = new Label("Gender:");
		genderLabel.setBounds(20,220,140,50);
		heightLabel = new Label("Height(in metres):");
		heightLabel.setBounds(20,280,140,50);
		weightLabel = new Label("Weight(in Kg):");
		weightLabel.setBounds(20,340,140,50);
		
		nameField = new TextField(15);
		nameField.setBounds(210,110,200,30);
		ageField = new TextField(10);
		ageField.setBounds(210,170,200,30);
		heightField = new TextField(5);
		heightField.setBounds(210,290,200,30);
		weightField = new TextField(5);	
		weightField.setBounds(210,350,200,30);	

		genderChoice = new CheckboxGroup();
		c1 = new Checkbox("Male",genderChoice,false);
		c1.setBounds(210,230,60,30);					
		c2 = new Checkbox("Female",genderChoice,false);
		c2.setBounds(280,230,100,30);
		

		submit = new Button("Submit");
		submit.setBounds(100,410,200,40);
		
		details = new TextArea("",10,40);
		details.setBounds(20,480,400,180);
		add(nameLabel);
		add(nameField);
		add(ageLabel);
		add(ageField);
		add(genderLabel);
		add(c1);
		add(c2);	
		add(heightLabel);
		add(heightField);
		add(weightLabel);
		add(weightField);
		add(submit);
		add(details);

		submit.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);

		picture=getImage(getDocumentBase(),"bmi2.jpg");
		pic=getImage(getDocumentBase(),"bmi.png");


	}
public void paint(Graphics g)
{
g.setColor(Color.yellow);
g.fillRect(565,100,400,306);
g.drawImage(picture,640,120,this);
g.drawImage(pic,455,265,this);}
		
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == submit)	
		{
			ht  = Float.parseFloat(heightField.getText());	
			wt = Float.parseFloat(weightField.getText());
			age = Integer.parseInt(ageField.getText());
			bmi = wt/(ht*ht);
			if(bmi<18.5)
			{
				bmiFinal = bmi +" (Undernourished)";
			}
			
			else if(bmi>25.0 && bmi<29.9)
			{
				bmiFinal =bmi +" (Overweight)";
			}
  			else if(bmi>=30.0)
			{
				bmiFinal =bmi +" (Obese)";
			}
			
			else
			{
				bmiFinal =bmi +" (Normal)";
			}
			
			if(age<18)
			{
				details.setText("BMI is not calculated for age less than 18");	
			}
			else
			{
 				details.setText("Name: "+nameField.getText()+"\nAge: "+age+"\nGender: "+genderChoice.getSelectedCheckbox().getLabel()+"\nHeight: "+ht+"\nWeight: "+wt+"\nBMI:"+bmiFinal);				
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}

	
}

// <applet code="BMIcalculator" width=400 height=150>
// </applet>


