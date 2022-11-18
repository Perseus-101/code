import DS.Stack;
import DS.Queue;
import java.util.Scanner;

class implementDS{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		//Stack obj1=new Stack();
		Queue obj2=new Queue();
		int[] arr=new int[10];
		int top=0;
		boolean loop=true;
		int f,r;
		f=r=1;
		int ch=0;
		System.out.println("Enter the choice:\n1.Stack Operations\n2.Queue Operations");
		ch=sc.nextInt();
		if(ch==1){
				System.out.println("Enter the string:");
				String input=sc.next();
				int Stacksize=input.length();
				Stack st=new Stack(Stacksize);
				
				for(int i=0;i<Stacksize;i++){
					char cha=input.charAt(i);
					st.push(cha);
				}
				
				while(!st.isEmpty()){
					char cha=st.pop();
					System.out.println(cha);
				}
				/*System.out.println("Enter the string:");
				str=sc.next();
		 		char ch[]=str.toCharArray();
		 		int size=ch.length;
		 		Stack stack=new Stack(size);*/
		 		}		
		else{
		
			while(loop){
				System.out.println("Enter the choice:\n1.Insert\n2.Delete\n3.Peek\n4.Exit");
				int choice=sc.nextInt();
				switch(choice){
					case 1:r=obj2.insertQ(arr,f,r);
			       			break;
		       			case 2:f=obj2.deleteQ(arr,f,r);
						break;
					case 3:obj2.peek(arr,f,r);
						break;
					default:loop=false;
		 				System.out.println("Invalid Option");
						break;
				}
			}
		}
	}
}	

