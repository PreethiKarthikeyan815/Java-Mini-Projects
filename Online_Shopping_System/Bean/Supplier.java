package Bean;

public class Supplier {
    private long supplierID;
    private String name;
    private String address;
    private  Item item;
    private  int quantity;

    public Supplier(long supplierID, String name, String address, Item item) {

        this.supplierID = supplierID;
        this.name = name;
        this.address = address;
        this.item = item;


    }

    public long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(long supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }



    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", item=" + item +

                '}';
    }
}
