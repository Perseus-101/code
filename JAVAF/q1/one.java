import java.io.*;

public class one {
    //For the first assigment we use BufferedReader class
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException
    {
        int num1, num2, sum = 0;
        System.out.println("Enter 1st number: ");
        num1 = Integer.parseInt(br.readLine());
        System.out.println("Enter 2nd number: ");
        num2 = Integer.parseInt(br.readLine());

        // Addition of numbers from number1 to number2
        int temp = num1;
        for(;temp<=num2;temp++)
            sum=sum+temp;
        System.out.println("\nSum of numbers between them: "+sum);

        //Find Maximum of two numbers
        if(num1<num2)
            System.out.println(num2+" is greater\n");
        else
            System.out.println(num1 +" is greater\n");
        
        //Print the multiplication tables of number1 and number2
        for(int i=1; i<=10;i++)
            System.out.println(num1+"*"+i+"="+num1*i);
        
        System.out.println("\n");

        for(int i=1; i<=10;i++)
            System.out.println(num2+"*"+i+"="+num2*i);
    }
}
