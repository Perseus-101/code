import java.io.*;

public class stud {
    int roll, mark;
    String name;

    public stud(int r, String n, int m){
        roll = r;
        name = n;
        mark = m;
    }

    static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int num, max=0, maxn=0;
        System.out.println("Enter Number of Students: ");
        num = Integer.parseInt(br.readLine());

        stud[] student = new stud[num];

        for(int i=0;i<num;i++){
            System.out.println("Roll Number: ");
            int roll = Integer.parseInt(br.readLine());
            System.out.println("Name: ");
            String name = br.readLine();
            System.out.println("Marks: ");
            int mark = Integer.parseInt(br.readLine());

            student[i] = new stud(roll, name, mark);

            if(student[i].mark>max){
                max = student[i].mark;
                maxn = student[i].roll;
            }
        }
        
        //Display the student scoring maximum marks
        for(int i=0;i<num;i++){
            if(student[i].roll==maxn){
                System.out.println("\nName: "+student[i].name+"\nRoll Number: "+student[i].roll+"\nMark: "+student[i].mark);
            }
            
        }
    }
}
