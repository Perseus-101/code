import java.util.*;

class InvalidDateException extends Exception {

      String msg;

      InvalidDateException(String msg)
      {

            this.msg=msg;
      }
}

public class MyDate {    

      static int day;
      static int mon;
      static int year;

      public static void acceptDate()
      {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the day as dd: ");
            day=sc.nextInt();
            System.out.print("Enter the day as mm: ");
            mon=sc.nextInt();
            System.out.print("Enter the day as yyyy: ");
            year=sc.nextInt();
      }

      public static void displayDate()
      {
            System.out.println("The entered date is: "+day+"-"+mon+"-"+year);
      }

      public static void main(String[] args)
      {
            System.out.println("-Enter the date-");            
            MyDate.acceptDate();

            try 
            {
                  if(day<=0 || day>31 || mon<=0 || mon>12) //|| year>2022)
                  {
                        throw new InvalidDateException("The date entered is invalid!");
                  }

                  if(year%4==0)
                  {
                        if(mon==2 && day>29)
                        {
                              throw new InvalidDateException("The date entered is invalid!(leap year)");
                        }
                  }
                  else
                  {
                        if(mon==2 && day>28)
                        {
                              throw new InvalidDateException("The date entered is invalid!(not a leap year)");
                        }
                  }  
            }
            catch(InvalidDateException e)
            {
                  System.out.println(e);        
                  System.out.println("-Re-enter the date-");    
                  MyDate.acceptDate();
            }

            MyDate.displayDate();                 
      }
}


