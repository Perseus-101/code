package SERIES;

public class numclass {
    public void number(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter 'n' terms: ");
        int n = sc.nextInt();

        prime obj1 = new prime();
        System.out.print("\nPrime Numbers till 'n' terms: ");
        obj1.primenum(n);

        fib obj2 = new fib();
        System.out.print("\nFibonacci Series till 'n' terms: ");
        obj2.fibonacci(n);

        sq obj3 = new sq();
        System.out.print("\nSqaures till 'n' terms: \n");
        obj3.squares(n);

    }

    class prime{
        public void primenum(int n){
            for(int i=0,j=2;i<n;j++)
            {
                int count = 0;
                for(int k=1;k<=j;k++)
                {
                    if(j%k==0)
                        count++;
                }
                if(count==2){
                    System.out.print(j+" ");
                    i++;
                }
            }
        }
    }

    class fib{
        public void fibonacci(int n){
            int t1=0, t2=1, t3=t1+t2;
            System.out.print(t1+" "+t2+" ");
            for(int i=3; i<=n; i++)
            {
                System.out.print(t3+" ");
                t1 = t2;
                t2 = t3;
                t3 = t1+t2;
            }
        }
    }

    class sq{
        public void squares(int n){
            for(int i=1;i<=n;i++)
            {
                System.out.print("Square of "+i+": "+i*i+"\n");
            }
        }
    }
}
