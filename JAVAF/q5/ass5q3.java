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
		setTitle("LOGIN  SCREEN");
		setBounds(300,90,900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		
		c=getContentPane();
		c.setLayout(null);
		
		title = new JLabel("LOGIN SCREEN");
		title.setFont(new Font("Arial",Font.PLAIN,30));
		title.setSize(300,30);
		title.setLocation(300,30);
		c.add(title);

		name = new JLabel("Username");
                name.setFont(new Font("Arial",Font.PLAIN,20));
                name.setSize(100,20);
                name.setLocation(100,100);
                c.add(name);
		
		tname = new JTextField();
		tname.setFont(new Font("Arial",Font.PLAIN,15));
		tname.setSize(190,20);
                tname.setLocation(200,100);
                c.add(tname);

		mno = new JLabel("Password");
                mno.setFont(new Font("Arial",Font.PLAIN,20));
                mno.setSize(100,20);
                mno.setLocation(100,150);
                c.add(mno);

		tmno = new JTextField();
                tmno.setFont(new Font("Arial",Font.PLAIN,15));
                tmno.setSize(150,20);
                tmno.setLocation(200,150);
                c.add(tmno);		

		sub = new JButton("LOGIN");
                sub.setFont(new Font("Arial",Font.PLAIN,15));
                sub.setSize(100,20);
                sub.setLocation(150,450);
		sub.addActionListener(this);
                c.add(sub);
		
		reset = new JButton("Reset");
                reset.setFont(new Font("Arial",Font.PLAIN,15));
                reset.setSize(100,20);
                reset.setLocation(270,450);
                reset.addActionListener(this);
                c.add(reset);

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
				String d,data;
				String data1 =name.getText();
				String data2= mno.getText();	
				if(data1.length<8)
					d="Password length should be more3 than 8";
				else
					data="Valid";

								
			
				tout.setText(data+d);
				tout.setEditable(false);
				res.setText(" Successfully..");

		}
		if(e.getSource()==reset)
			{
				tmno.setText("");
				tname.setText("");
			}
		/*String data;
		String data1;
		int d=0;
		if(e.getSource()==sub)
		{
			if(d<3)
			{
				String str1=name.getText();
				char []str2=mno.getText();
				if(str1.equals("")||str2.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Username and password should not be blank",JOptionPane.PLAIN_MESSAGE);
					d++;
				}
				else if(str2.length<0)
				{
					JOptionPane.showMessageDialog(null,"password length should be more than 3",JOptionPane.PLAIN_MESSAGE);
				}
				else if(str1.equals(str2))
				{
					JOptionPane.showMessageDialog(null,"valid","DIsplay",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"3 Invalid attempts","Display",JOptionPane.PLAIN_MESSAGE);
				}
			}
			if(e.getSource()==reset)
			{
				name.setText("");
				mno.setText("");
			}
		}*/
	}
}


class ass5q3
{
	public static void main(String[] args)throws IOException
	{
		MyFrame f = new MyFrame();
	}
}


