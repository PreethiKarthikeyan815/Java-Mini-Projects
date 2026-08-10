package bean;

import java.util.List;

public class TruckDetails extends VehicleDetails{
    private double roadTax;

    public TruckDetails(int vehicleID, String vehicleName, int capacity, List<PackageDetails> packageDetails, double roadTax) {
        super(vehicleID, vehicleName, capacity, packageDetails);
        this.roadTax = roadTax;
    }

    public double getRoadTax() {
        return roadTax;
    }

    public void setRoadTax(double roadTax) {
        this.roadTax = roadTax;
    }

    @Override
    public String toString() {
        return "TruckDetails{" +
                "vehicleID=" + getVehicleID()+
                ", vehicleName='" + getVehicleName() + '\'' +
                ", capacity=" + getCapacity()+
                ", packageDetails=" + getPackageDetails() +
                "roadTax=" + roadTax +
                '}';
    }
}
