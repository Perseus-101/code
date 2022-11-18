import java.util.*;
import java.lang.*;

class InvalidEmailException extends Exception
{
	String s;
	InvalidEmailException(String s)//
	{
		this.s=s;
	}
	 public String toString()//to  convert object to string
	 {	
		 return s;
	}
}
class invalidemail
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		int i, cnt1=0,cnt2=0,l;
		char x,ch;

		System.out.println("Enter Email");
		String s= sc.next();

		l=s.length();
		try
		{
			ch=s.charAt(0);
			if(Character.isDigit(ch))
			{
				throw new InvalidEmailException
					("Email can't start with Digit");
			}

			if(s.endsWith(".com.com"))
			{
				throw new InvalidEmailException
					("Invalid Email");
			}
			for (i=0;i<1;i++)
			{
				ch=s.charAt(i);
				if (ch=='0')
				{
					x=s.charAt(i-1);
					if (ch=='0')
					{
						x=s.charAt(i-1);
						if(x=='.')
							throw new InvalidEmailException
								("Invalid syntax");
						cnt2++;
					}
					if(ch=='#'||ch=='$'||ch=='%'||
					   ch=='^'||ch=='&'||ch=='*'||ch=='('||ch=='_'||ch=='='||ch=='+'||ch==')')
					   throw new InvalidEmailException
					   ("Invalidsymbolused");}
					   if(cnt2==0||cnt2>1)
					   throw new InvalidEmailException
					     ("Invalid no of symbols");
				
			}
		}
		catch(InvalidEmailException e)
		{
			System.out.println(e);
		}
			}
		}



