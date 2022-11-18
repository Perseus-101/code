package DS;
import java.util.Scanner;

public class Queue{
	Scanner sc=new Scanner(System.in);
	public boolean isFull(int[] arr,int f,int r){
		if(r==arr.length){
			return true;
		}
		return false;
	}

	public boolean isEmpty(int[] arr,int f,int r){
		if(f==r){
			return true;
		}
		return false;
	}

	public int insertQ(int[]  arr,int f,int r){
		if(isFull(arr,f,r)){
			System.out.println("The queue is FULL.");
		}
		System.out.println("Enter the elements:");
		int num=sc.nextInt();
		arr[r+1]=num;
		r++;
		return r;
	}

	public int deleteQ(int[] arr,int f,int r){
		if(isEmpty(arr,f,r)){
			System.out.println("The queue is EMPTY.");
			return 0;
		}
		f++;
		arr[f]=0;
		return f;
	}

	public void peek(int[] arr,int f,int r){
		if(isEmpty(arr,f,r)){
			System.out.println("The queue is EMPTY.");
			return;
		}
		System.out.println("The queue is :");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		return;
	}
}
