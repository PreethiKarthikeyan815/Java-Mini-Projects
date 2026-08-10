package service;

import Bean.Item;
import Bean.Order;
import Bean.Privilege;
import Bean.Supplier;
import Excep.NotEnoughStockException;
import Excep.OrderAlreadyFullfilledException;
import Excep.OrderNotFoundException;
import utility.OnlineShoppingInterface;

import java.util.*;


public class OnlineShoppingSystem implements OnlineShoppingInterface {

    List<Order> orders= new ArrayList<>();
    List<Supplier> suppliers=new ArrayList<>();
    Scanner sc= new Scanner(System.in);
   static long  s_id=1001;
   static  long i_id=500;
    public OnlineShoppingSystem() {
        System.out.println("Enter No of Supplier:");
        int n= sc.nextInt();
        List<String> str =new ArrayList<>();

        for(int i=0; i<n; i++){
            System.out.println("Your Supplier ID is:"+s_id);

            System.out.println("Enter Name:");
            String s_name=sc.next();
            System.out.println("Enter Address:");
            String s_address=sc.next();
            System.out.println("Item Details:- ");
            System.out.println("Your  ItemId is :"+i_id);
            System.out.println("Enter Name:");
            String i_name= sc.next();
            System.out.println("Enter Price Of Item:");
            double i_price=sc.nextDouble();
            System.out.println("Enter Quantity:");
            int i_quantity=sc.nextInt();
            Item it = new Item(i_id++,i_name, i_price, i_quantity );
            Supplier sp= new Supplier(s_id++, s_name, s_address, it);
            suppliers.add(sp);
            if(!str.contains(i_name))
                str.add(i_name);

        }

        System.out.println("Items Available are listed below:-");
        for(int k=0; k<str.size(); k++){
            System.out.println((k+1)+"----> "+str.get(k));
        }
        System.out.println("");

    }

    public OnlineShoppingSystem(Supplier sp) {
        suppliers.add(sp);
    }

    @Override
    public boolean AddOrder(Order o) {
        double tot = 0;
        for (Item i : o.getItems()) {
            boolean f = false;

            for (Supplier k : suppliers) {

                if (k.getItem().getItemId() == i.getItemId()) {
                    f = true;
                    if (k.getItem().getQuantity() < i.getQuantity())
                        return false;
                    i.setPrice(k.getItem().getPrice());
                    i.setName(k.getItem().getName());
                    tot = tot + k.getItem().getPrice() * i.getQuantity();
                    break;
                }
            }
            if (!f)
                return false;
        }
                o.setOrderAmount(tot);


                if (o.getCustomer() instanceof Privilege)
                    o.setAmountAfterDiscount(o.getOrderAmount() * 0.9);
                else {
                    double dis = 0;
                    double amo = o.getOrderAmount();
                    if (amo > 1000 && amo <= 2000)
                        dis = 50;
                    else if (amo > 2000 && amo <= 5000)
                        dis = 100;
                    else if (amo > 5000 && amo <= 10000)
                        dis = 200;
                    else if(amo>10000)
                        dis = 300;
                    o.setAmountAfterDiscount(o.getOrderAmount() - dis);
                }

                o.setOrderStatus("In-Progress");
                orders.add(o);
                orders.stream().forEach(System.out:: println);
                return true;

    }

    @Override
    public boolean CancelOrder(long orderID) throws OrderNotFoundException {

       Iterator<Order> it= orders.iterator();
       while(it.hasNext()){
           Order o= it.next();
           if(o.getOrderID()== orderID){
               it.remove();
               orders.stream().forEach(System.out::println);
               return true;
           }
       }
        throw  new OrderNotFoundException("Invalid OrderID");
    }

    @Override
    public boolean cancelItem(long orderID, int itemId) throws OrderNotFoundException {




        for(Order o: orders){
            if(o.getOrderID()==orderID){

                Iterator<Item> it=o.getItems().iterator();
                 while(it.hasNext()){
                     Item i= it.next();
                     if(i.getItemId()==itemId){
                         o.setOrderAmount(o.getOrderAmount()-(i.getPrice()*i.getQuantity()));
                         it.remove();
                         orders.stream().forEach(System.out::println);
                         return true;
                     }
                 }

            }
        }
        throw new OrderNotFoundException("Invalid OrderId");




    }

    @Override
    public boolean fulfillOrder(long orderID) throws OrderAlreadyFullfilledException, NotEnoughStockException {

        for(Order o :orders){
            if(o.getOrderID()== orderID) {
                if(o.getOrderStatus().equals("Fulfilled"))
                    throw new OrderAlreadyFullfilledException("Order Aldready Fullfilled");

                for (Item i : o.getItems()) {
                    boolean f=false;

                    for(Supplier s : suppliers){
                      if(s.getItem().getItemId()== i.getItemId()){
                          f=true;
                          if(s.getItem().getQuantity()<i.getQuantity())
                              throw new NotEnoughStockException("Out Of Stock");

                          s.getItem().setQuantity(s.getItem().getQuantity()-i.getQuantity());
                       break;
                      }
                    }
                    if(!f)
                        return false;
                }
                o.setOrderStatus("Fulfilled");
                orders.stream().forEach(System.out::println);
                return true;
            }
        }
        return false;
    }

    @Override
    public HashMap<Long, Integer> getStockDetails() {

        HashMap <Long, Integer> h=new HashMap<>();


        for(Supplier s: suppliers){
            h.put(s.getItem().getItemId(), h.getOrDefault(s.getItem().getItemId(),0)+s.getItem().getQuantity());
        }

        return h;
    }

    @Override
    public ArrayList<Order> listOrderbyPrice(String status) {
        //List<Order> l= new ArrayList<>();




      return new ArrayList<>( orders.stream().filter(o->o.getOrderStatus().equals(status)).sorted(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Double.compare(o2.getOrderAmount(), o1.getOrderAmount());
            }
        })
              .toList()
      );

    }
}
