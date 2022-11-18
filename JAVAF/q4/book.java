import java.io.*;
import java.util.*;
class book
{
	public static void main(String args[])throws IOException
	{
		if(args.length==1)
		{
			int flag=0,c=0,price=0,qty=0;
			
			RandomAccessFile fr=new RandomAccessFile(args[0],"r");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Scanner sc=new Scanner(System.in); 
			
		
			String c1="";
			do{
				System.out.println("1 Searching for specific book");
				System.out.println("2 find costliest book");
				System.out.println("3 display all books");
				System.out.println("4 exit");
				do{System.out.println("enter choice");
				   c=sc.nextInt();}while(c<0);
			        switch(c)
				{
				 case 1:
					String line;
					//StringTokenizer s=new StringTokenizer(line);
					System.out.println("enter book name");
                                        String s=br.readLine();
					while((line=br.readLine())!=null)
					{	
					String tok[]=line.split("");
					
					if(s.equals(tok[1]))
					{
					 flag=1;
			 		 System.out.println("the book details are= "+line);
					 }
					}
					if(flag==0)
					{
			                 System.out.println("book name not found");
		 			}
	       				fr.seek(0);
					break;
				case 2:
					String book1="";
					int max=0;
					 String line2;

					while((line2=br.readLine())!=null)
					{
					 String tok[]=line2.split("");
					 price=Integer.parseInt(tok[2]);
					 if(price>max)
					{
	       				 max=price;
					 book1=line2;}}
				         System.out.println("book with max cost is="+book1);
 					fr.seek(0);
					break;
				case 3:
					int totalc=0;
                     				 String line3=br.readLine();
   
					System.out.println("Details of the book");
					System.out.println(line3);

					while((line3=br.readLine())!=null)
                                        {
                                         String tok[]=line3.split("");
 					 System.out.println(line3);					 
					 price=Integer.parseInt(tok[3]);
					 qty=Integer.parseInt(tok[2]);
					 totalc=price*qty;
					 System.out.println("total cost is="+ totalc);
					}
					fr.seek(0);
					break;
				case 4:
					System.exit(0);
				default:  System.out.println("invalid choice"); break;	
				}
			}while(c<5);
		}
		else
			 System.out.println("invalid arguments");	
	}
}





