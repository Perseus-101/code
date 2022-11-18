import java.io.*;

public class two {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String str;
        System.out.println("Enter String: ");
        str = br.readLine();

        //Print reverse of the string
        char ch[]=str.toCharArray();
        for(int i=str.length()-1;i>=0;i--)
            System.out.println(ch[i]+" ");

        //Find lenght of the string
        System.out.println("Lenght of string: "+str.length());

        //Print alternative characters of the string
        System.out.println("Alernative Characters: ");
        for(int i=0;i<str.length();i+=2)
        {
            System.out.println(ch[i]);
        }
    }
}
