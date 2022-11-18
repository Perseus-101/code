package MATRIX;

public class matclass{

    public void accept(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter Number of Rows: ");
        int r = sc.nextInt();
        System.out.print("Enter Number of Columns: ");
        int c = sc.nextInt();

        int arr1[][] = new int[r][c];
        int arr2[][] = new int[r][c];

        System.out.print("\nEnter the elements of Main Matrix: ");
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                arr1[i][j] = sc.nextInt();

        System.out.print("\nEnter the elements of Secondary Matrix: ");
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                arr2[i][j] = sc.nextInt();

        displaymat obj1 = new displaymat();
        System.out.println("\nMain Matrix: ");
        obj1.display(arr1,r,c);
        System.out.println("\nSecondary Matrix: ");
        obj1.display(arr2,r,c);

        addmat obj2 = new addmat();
        System.out.println("\nAddition of the Matrices: ");
        obj2.add(arr1,arr2,r,c);

        maxmat obj3 = new maxmat();
        obj3.max(arr1,r,c);
    }

    class displaymat{
        public void display(int arr[][], int r, int c){
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++)
                    System.out.print(arr[i][j]+" ");
                System.out.print("\n");
            }     
        }
    }

    class addmat{
        public void add(int arr1[][], int arr2[][], int r, int c){
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    System.out.print(arr1[i][j]+arr2[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
    }

    class maxmat{
        public void max(int arr[][], int r, int c){
            int maxelement = 0;
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    if(arr[i][j]>maxelement)
                        maxelement = arr[i][j];
            
            System.out.println("\nMaximum of the matrix element: "+maxelement);
        }
    }
}