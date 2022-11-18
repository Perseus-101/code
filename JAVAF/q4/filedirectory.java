import java.io.*;
import java.util.*;
class filedirectory
{
	public static void main(String args[])throws IOException
	
	{
		Scanner sc =new Scanner(System.in);

		if(args.length!=1)
		{
			System.out.println("Invalid no of Arguments");
		}
		else
		{
			String name=args[0];
			File fp=new File(name);
			int cnt=0,c;
			if(fp.isFile())
			{
				String p=fp.getAbsolutePath();
				System.out.println("The path of file is= " +p);
				long l=fp.length();
				System.out.println("length of file is= "+l);
				long d=fp.lastModified();
				System.out.println("lastmodified data id= "+d);
			}
			else if (fp.isDirectory())
			{
				System.out.println(name +" is the name of directory");
				String a[]=fp.list();
				for(int i=0;i<a.length;i++)
				{
					File fpl=new File(name,a[i]);
					
			
						if(fpl.isFile())
						{
							cnt++;
							System.out.println("Name is "+a[i]);
							if(a[i].endsWith(".txt"))
							{
								System.out.println("Do you want to delete the file\n 1 to delete\n 0 to continue");
								do{c=sc.nextInt();}while(c<0);
								
								if(c==1)
								{
									fp.delete();
									cnt--;
								}
							}
						}
					
					System.out.println("total no of files in the directory are "+cnt);
				}
			}
				else
				{
					System.out.println("no such file or directory found");
				}
			}
		}
		
	}



