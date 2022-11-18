import java.io.*;

class Person
{
	String name;
	String address;
	Person(String na,String a)
	{
		name = na;
		address = a;
	}
}

class Student extends Person
{
	String course[] = new String[20];
	String grade[] = new String[20];
	int n;
	Student(String na, String a)
	{
		super(na,a);
	}

	void addc() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Number of Courses: ");
		int q = Integer.parseInt(br.readLine());
		n = q;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the Name of the Subject "+(i+1)+": ");
			course[i] = br.readLine();
			System.out.print("Enter the Grades of Subject "+(i+1)+": ");
			grade[i] = br.readLine();
		}
	}
	void display() throws IOException
	{
		System.out.println("\nName is "+name);
		System.out.println("Address is "+address);
		System.out.println("Course List with Marks");
		System.out.println("Course\t\t:\t\tGrades");
		for(int i=0;i<n;i++)
		{
			System.out.println(course[i]+"\t\t:\t\t"+grade[i]);
		}
	}
}

class Teacher extends Person
{
	String course[] = new String[100];
	int na;
	Teacher(String na, String a)
	{
		super(na,a);
	}
	void addtc() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Number of Courses: ");
		int q = Integer.parseInt(br.readLine());
		na = q;
		for(int i=0;i<na;i++)
		{
			System.out.print("Enter the Name of Subject "+(i+1)+": ");
			course[i] = br.readLine();
		}
	}

	void add_one_course() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Name of Subject: ");
		course[na++]=br.readLine();
	}

	void delete() throws IOException
	{
		int i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Number of Courses to be Deleted: ");
		String cname = br.readLine();
		for(i=0;i<na;i++)
		{
			if(course[i].equals(cname))
			{
				break;
			}
		}
		for(int j=i+1;j<na;j++)
		{
			course[j-1] = course[j];
		}
		na = na -1;
	}
	void display() throws IOException
	{
		System.out.println("\nName is "+name);
		System.out.println("Address is "+address);
		System.out.println("Course List");
		for(int i=0;i<na;i++)
		{
			System.out.println(course[i]);
		}
	}
}


class First
{
	public static void main(String args[]) throws IOException
	{
		int ch, nums = 0, numt = 0, flag;
		String name, add;
		Student s[] = new Student[100];
		Teacher t[] = new Teacher[100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.print("1. Add Student\n2. Show Student Data\n3. Add Teacher\n4. Add Course for Teacher\n5. Delete Course for Teacher\n6. Display Teacher Data\n7. Exit\nEnter Your Choice:\t");
			ch = Integer.parseInt(br.readLine());
			if(ch==7)
				break;
			switch(ch)
			{
				case 1 : System.out.print("Enter the Name:\t");
					 name = br.readLine();
					 System.out.print("Enter the Address:\t");
					 add = br.readLine();
					 s[nums] = new Student(name,add);
					 s[nums].addc();
					 nums++;
					 System.out.println("\nDetails Added\n");
					 break;
				case 2 : for(int i=0; i<nums;i++)
					 {
						 s[i].display();
						 System.out.println("\n");
					 }
					 break;
				case 3 : System.out.print("Enter the Name:\t");
					 name = br.readLine();
					 System.out.print("Enter the Address:\t");
					 add = br.readLine();
					 t[numt] = new Teacher(name,add);
					 t[numt].addtc();
					 numt++;
					 System.out.println("\nDetails Added\n");
					 break;
				case 4 : flag = 0 ;
					 System.out.print("Enter the name of the Teacher:\t");
					 name = br.readLine();
					 for(int i=0;i<numt;i++)
					 {
						 if((t[i].name).equals(name))
						 {
							 flag = 1;
							 t[i].add_one_course();
							 break;
						 }
					 }
					 if(flag==0)
					 {
						 System.out.println("NO Teacher Found with Record");
					 }
					 break;
				case 5 : flag = 0;
					 System.out.print("Enter the Name of Teacher:\t");
					 name = br.readLine();
					 for(int i=0;i<numt;i++)
					 {
						 if((t[i].name).equals(name))
						 {
							 flag = 1;
							 t[i].delete();
							 break;
						 }
					 }
					 if(flag==0)
					 {
						 System.out.println("No Teacher Found With This Record");
					 }
					 break;
				case 6 : for(int i=0;i<numt;i++)
					 {
						 t[i].display();
					 }
					 break;
				default : System.out.print("Enter Correct Choice:\t");

			}
		}while(ch!=7);
	}
}
