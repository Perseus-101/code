package DS;
import java.util.Scanner;
import java.lang.*;


public class Stack{
	int size;
	char[] stackArray;
	int top;
	public Stack(int s){
		size=s;
		stackArray=new char[size];
		top=-1;
	}
	public void push(char j){
		stackArray[++top]=j;
		}
	public char pop(){
		return stackArray[top--];
		}
	public char peek(){
		return stackArray[top];
		}
	public boolean isEmpty(){
		return(top==-1);
		}
	public boolean isFull(){
	return(top==size-1);
	}
}
	
	
		
