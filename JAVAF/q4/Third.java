import java.io.*;

class Third
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n,i,sum=0;
			System.out.print("Enter the Number of Elements:\t");
			n=Integer.parseInt(br.readLine());
			int A[] = new int[n];
			for(i=0;i<n;i++)
			{
				System.out.print("Enter the Element:\t");
				A[i]=Integer.parseInt(br.readLine());
				sum = sum + A[i];
			}
			System.out.println("Average = "+(sum/n));
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("Exception Caught "+a);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Exception Caught "+ae);
		}
		catch(NumberFormatException an)
		{
			System.out.println("Exception Caught "+an);
		}
	}
}
