import java.io.*;

interface Stack
{
	void insert(char c);
	char delete();
	char peek();
	boolean isFull();
	boolean isEmpty();
}

class check_stack implements Stack
{
	char st[] = new char[100];
	public static int top = -1;
	public boolean isEmpty()
	{
		if(check_stack.top==-1)
		{
			return true;
		}
		return false;
	}

	public boolean isFull()
	{
		if(check_stack.top==100)
		{
			return true;
		}
		return false;
	}

	public char peek()
	{
		return st[check_stack.top];
	}

	public void insert(char c)
	{
		if(isFull())
		{
			System.out.println("Stack is Full");
		}
		else
		{
			st[++check_stack.top]=c;
		}
	}

	public char delete()
	{
		char del;
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
		}
		del = st[check_stack.top--];
		return del;
	}
}

class Third
{
	public static void main(String args[]) throws IOException
	{
		int ch;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter The String you want to Check: ");
		String s = br.readLine();
		check_stack st = new check_stack();

		for(int i=0;i<s.length();i++)
		{
			st.insert(s.charAt(i));
		}

		String reverseString = "";

		while(!st.isEmpty())
		{
			reverseString = reverseString + st.delete();
		}

		if(s.equals(reverseString))
		{
			System.out.println("The String is a PALINDROME");
		}
		else
		{
			System.out.println("The String is NOT a PALIDROME");
		}
	}
}
