package Main;

import Bean.*;
import Excep.NotEnoughStockException;
import Excep.OrderAlreadyFullfilledException;
import Excep.OrderNotFoundException;
import service.OnlineShoppingSystem;

import java.util.*;

public class Test {

  static  int o_id=1234;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int ch;
        OnlineShoppingSystem oss= new OnlineShoppingSystem();

        do{

            System.out.println("1----> Place  Order");
            System.out.println("2----> Cancel Order");
            System.out.println("3----> CancelItem");
            System.out.println("4----> Fullfill Order");
            System.out.println("5----> Get Stock Details");
            System.out.println("6----> ListOredr By Price");
            System.out.println("7----> Exit");
            System.out.println("Enter your choice:");
            ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Add Order");
                    System.out.println();
                    System.out.println("Enter Person Details:-");
                    System.out.println("Enter Name:");
                    String p_name= sc.next();
                    System.out.println("Enter DOB:");
                    String p_dob=sc.next();
                    System.out.println("Enter Gender:");
                    String p_gender=sc.next();
                   // Person p= new Person(p_name, p_dob, p_gender);

                    System.out.println("Enter CustomerId:");
                    String c_id=sc.next();
                    System.out.println("Enter Address:");
                    String c_address= sc.next();
                    System.out.println("Enter phone: ");
                    String c_phone = sc.next();
                    System.out.println("Enter email: ");
                    String c_email= sc.next();




                    List<Item> order_items= new ArrayList<>();
                    System.out.println("Enter no of Items:");
                    int i_noToOrder = sc.nextInt();
                    for(int k=0; k<i_noToOrder; k++){
                        System.out.println("Enter Itemid:");
                        long oo_id=sc.nextLong();
                        //System.out.println("Enter Name:");
                        //String oo_name=sc.next();
                        System.out.println("Enter Quantity:");
                        int quanti=sc.nextInt();
                        Item x=new Item(oo_id, null , 0,quanti);
                        order_items.add(x);
                    }

                    System.out.println("Order Details:-");
                    System.out.println("Your OrderId is "+ o_id);
                    System.out.println();
                    System.out.println("Please Remember your OrderId!!!");
                    System.out.println("Enter Oredr date :");
                    String o_dob= sc.next();
                   // Customer c=new Customer(c_id, c_address, c_phone, c_email,);
                    System.out.println("Enter Your choice:\n1--->Previlege\n2--->ValueAdd");
                    int i=sc.nextInt();
                    if(i==1){
                        Privilege pri =new Privilege(p_name, p_dob, p_gender, c_id, c_address, c_phone, c_email,10);
                        Order ord =new Order(o_id++, o_dob, null, 0, 0, pri,order_items);
                        System.out.println("Whether Order Placed:? " + oss.AddOrder(ord));

                    }
                    else{
                        ValueAdd va = new ValueAdd(p_name, p_dob, p_gender, c_id, c_address,c_phone,c_email, 0);
                        Order ord =new Order(o_id++, o_dob, null, 0, 0, va, order_items);
                        System.out.println("Whether Order Placed:? " + oss.AddOrder(ord));
                    }

                    break;
                case 2:
                    try {
                        System.out.println("Cancel Order");
                        System.out.println("Enter orderId:");
                        long co_id = sc.nextLong();
                        System.out.println("Whether order Cancelled? : " + oss.CancelOrder(co_id));
                    } catch (OrderNotFoundException onf) {
                        System.out.println(onf);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Cancel Item :");
                        System.out.println("Enter OrderId:");
                        long ci_id = sc.nextLong();
                        System.out.println("Enter ItemId:");
                        int it_id = sc.nextInt();
                        System.out.println("Whether item in the order Cancelled? : " + oss.cancelItem(ci_id, it_id));
                    }catch (OrderNotFoundException onf){
                        System.out.println(onf);
                    }
                    break;
                case  4:
                    try {
                        System.out.println("Fullfill Order :");
                        System.out.println("Enter OrderId:");
                        long f_id = sc.nextLong();
                        System.out.println("Whether Order Fullfilled ?: " + oss.fulfillOrder(f_id));
                    }catch (OrderAlreadyFullfilledException onf){
                    System.out.println(onf);
                    }catch(NotEnoughStockException nes){
                        System.out.println(nes);
                    }
                    break;
                case 5:
                    System.out.println("StockDetails");
                    HashMap<Long, Integer> h = oss.getStockDetails();
                    for(Map.Entry<Long, Integer> e : h.entrySet()){
                        System.out.println(e.getKey()+" ---- "+e.getValue());
                    }
                    break;
                case 6:
                    System.out.println("Listing Orders By Price in Descending Order");
                    System.out.println("Enter Status of Order To Display:");
                    String status= sc.next();
                    List<Order> l= oss.listOrderbyPrice(status);
                    l.stream().forEach(k->System.out.println(k));
                    break;
                case 7:
                    break;

            }
        }while (ch != 7);
    }
}
