package utility;

import Bean.Order;
import Excep.NotEnoughStockException;
import Excep.OrderAlreadyFullfilledException;
import Excep.OrderNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;

public interface OnlineShoppingInterface {
    public boolean AddOrder(Order o);

    public boolean CancelOrder(long orderID)throws OrderNotFoundException;

    public boolean cancelItem(long orderID, int itemId)throws OrderNotFoundException;

    public boolean fulfillOrder(long orderID)throws OrderAlreadyFullfilledException, NotEnoughStockException;

    public HashMap<Long, Integer> getStockDetails();

    public ArrayList<Order> listOrderbyPrice(String status);

}
