package bean;

import java.util.ArrayList;
import java.util.List;

public class VehicleDetails {
    private  int vehicleID;
    private String vehicleName;
    private int capacity;
    private List<PackageDetails> packageDetails=new ArrayList<>();

    public VehicleDetails(int vehicleID, String vehicleName, int capacity, List<PackageDetails> packageDetails) {
        this.vehicleID = vehicleID;
        this.vehicleName = vehicleName;
        this.capacity = capacity;
        this.packageDetails = packageDetails;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<PackageDetails> getPackageDetails() {
        return packageDetails;
    }

    public void setPackageDetails(List<PackageDetails> packageDetails) {
        this.packageDetails = packageDetails;
    }
    public void addPackage(PackageDetails p)
    {

      this.packageDetails.add(p);
    }
    @Override
    public String toString() {
        return "VehicleDetails{" +
                "vehicleID=" + vehicleID +
                ", vehicleName='" + vehicleName + '\'' +
                ", capacity=" + capacity +
                ", packageDetails=" + packageDetails +
                '}';
    }
}
