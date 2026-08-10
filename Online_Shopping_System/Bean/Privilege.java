package Bean;

import java.util.Date;

public class Privilege extends Customer{
    private double duscountPercent;

    public Privilege(String name, String dob, String gender, String customerId, String address, String phone, String email, double duscountPercent) {
        super(name, dob, gender, customerId, address, phone, email);
        this.duscountPercent = duscountPercent;
    }

    public double getDuscountPercent() {
        return duscountPercent;
    }

    public void setDuscountPercent(double duscountPercent) {
        this.duscountPercent = duscountPercent;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "duscountPercent=" + duscountPercent +
                '}';
    }
}
