package Bean;

import java.util.Date;
import java.util.List;

public class Order {
    private long orderID;
    private String orederDate;
    private String  orderStatus;
    private double orderAmount;
    private double amountAfterDiscount;
  //  private  int quantity;
    private  Customer customer;
    private List<Item> items;

    public Order(long orderID, String orederDate, String orderStatus, double orderAmount, double amountAfterDiscount,  Customer customer, List<Item> items) {
        this.orderID = orderID;
        this.orederDate = orederDate;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.amountAfterDiscount = amountAfterDiscount;
    //    this.quantity = quantity;
        this.customer = customer;
        this.items = items;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public String getOrederDate() {
        return orederDate;
    }

    public void setOrederDate(String orederDate) {
        this.orederDate = orederDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getAmountAfterDiscount() {
        return amountAfterDiscount;
    }

    public void setAmountAfterDiscount(double amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

   /* public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
*/
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orederDate=" + orederDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderAmount=" + orderAmount +
                ", amountAfterDiscount=" + amountAfterDiscount +
              //  ", quantity=" + quantity +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }
}
