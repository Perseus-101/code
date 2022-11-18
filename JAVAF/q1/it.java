import java.io.*;

public class it {
    int item_code, price, quantity, tot_price;
    String name;

    public it(int c, int p, int q, int t, String n){
        item_code = c;
        price = p;
        quantity = q;
        name = n;
        tot_price = t;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        int num;
        System.out.println("Enter number of items: ");
        num = Integer.parseInt(br.readLine());
        it[] item = new it[num];

        for(int i=0;i<num;i++)
        {
            System.out.println("Item Code: ");
            int c = Integer.parseInt(br.readLine());
            System.out.println("Item Name: ");
            String n = br.readLine();
            System.out.println("Item Price: ");
            int p = Integer.parseInt(br.readLine());
            System.out.println("Item Quantity: ");
            int q = Integer.parseInt(br.readLine());
            int t = q*p;

            item[i] = new it(c,p,q,t,n);
        }

        for(int i=0;i<num-1;i++)
        {
            for(int j=0;j<num-i-1;j++)
            {
                if(item[j].price>item[j+1].price){
                    it temp = item[j];
                    item[j] = item[j+i];
                    item[j+i] = temp;
                }
            }
        }

        System.out.println("\nDetails of items on the basis of cost: \n");
        for(int i=0;i<num;i++)
        {
            System.out.println("Item Code: "+item[i].item_code);
            System.out.println("Item Name: "+item[i].name);
            System.out.println("Item Price: "+item[i].price);
            System.out.println("Item Quantity: "+item[i].quantity);
            System.out.println("Item Total Price: "+item[i].tot_price+"\n");
        }
    }
}
