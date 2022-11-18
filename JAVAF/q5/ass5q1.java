import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class MyFrame extends JFrame implements ActionListener
{
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel gender;
	private JRadioButton female;
	private JRadioButton female1;
	private JRadioButton male;
	private ButtonGroup gengp;
	private JLabel dob;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;
	private JLabel add;
	private JTextArea tadd;
	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;
	
	public MyFrame()
	{
		setTitle("number converter");
		setBounds(300,90,900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		
		c=getContentPane();
		c.setLayout(null);
		
		title = new JLabel("Number Converter");
		title.setFont(new Font("Arial",Font.PLAIN,30));
		title.setSize(300,30);
		title.setLocation(300,30);
		c.add(title);

		mno = new JLabel("Input ");
                mno.setFont(new Font("Arial",Font.PLAIN,20));
                mno.setSize(100,20);
                mno.setLocation(100,150);
                c.add(mno);

		tmno = new JTextField();
                tmno.setFont(new Font("Arial",Font.PLAIN,15));
                tmno.setSize(150,20);
                tmno.setLocation(200,150);
                c.add(tmno);

		male = new JRadioButton("Hexadecimla");
		male.setFont(new Font("Arial",Font.PLAIN,15));
		male.setSelected(true);
                male.setSize(75,20);
                male.setLocation(200,200);
                c.add(male);
	
		female = new JRadioButton("Decimal");
                female.setFont(new Font("Arial",Font.PLAIN,15));
                female.setSelected(false);
                female.setSize(80,20);
                female.setLocation(200,300);
                c.add(female);

		female1 = new JRadioButton("Octal");
                female1.setFont(new Font("Arial",Font.PLAIN,15));
                female1.setSelected(false);
                female1.setSize(80,20);
                female1.setLocation(200,400);
                c.add(female1);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);
		gengp.add(female1);

		sub = new JButton("Submit");
                sub.setFont(new Font("Arial",Font.PLAIN,15));
                sub.setSize(100,20);
                sub.setLocation(150,450);
		sub.addActionListener(this);
                c.add(sub);


		tout = new JTextArea();
                tout.setFont(new Font("Arial",Font.PLAIN,15));
                tout.setSize(300,400);
                tout.setLocation(500,100);
                tout.setLineWrap(true);
		tout.setEditable(false);
                c.add(tout);

		res = new JLabel("");
                res.setFont(new Font("Arial",Font.PLAIN,20));
                res.setSize(500,25);
                res.setLocation(100,500);
                c.add(res);

		
		resadd = new JTextArea();
                resadd.setFont(new Font("Arial",Font.PLAIN,15));
                resadd.setSize(200,75);
                resadd.setLocation(580,175);
                resadd.setLineWrap(true);
                c.add(resadd);


		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==sub)
		{
				int data1=0;
				String data=tmno.getText();
				data1=Integer.parseInt(data);
				String data2= "";					

				if(male.isSelected())                
					data2 = Integer.toHexString(data1);
				if(female.isSelected())
					data2 = data;
				if(female1.isSelected()) 
					data2 = Integer.toOctalString(data1); //convertStringToOctal(data);

				tout.setText( data2);
				tout.setEditable(false);
				res.setText(" Successfully..");

		}
	}
}


class ass5q1
{
	public static void main(String[] args)throws IOException
	{
		MyFrame f = new MyFrame();
	}
}
