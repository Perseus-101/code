import java.util.Scanner;


class Shape{
	String name;
	void accept(){}
	void display(){}
	void area(){}	
}

class Square extends Shape{
	int side;
	Scanner sc = new Scanner(System.in);
	public Square(){
		side = 0;
	}	
	
	public void accept(){
		System.out.println("Please enter the side of the square");
		side = sc.nextInt();
		
	}
	
	public void display(){
		System.out.println("The side of the square is "+side+" and the area is "+(side*side));
	}
	
	
}

class Circle extends Shape{
	int radius;
	Scanner sc = new Scanner(System.in);
	public Circle(){
		radius = 0;
	}	
	
	public void accept(){
		System.out.println("Please enter the radius of the circle");
		radius = sc.nextInt();
		
	}
	
	public void display(){
		System.out.println("The radius of the circle is "+radius+" and the area is "+(3.14*(radius*radius)));
	}
	
	
}



public class TestShape{
	public static void main(String args[]){
	
	Square sq = new Square();
	sq.accept();
	sq.display();
	
	Circle cr = new Circle();
	cr.accept();
	cr.display();
   }
}

