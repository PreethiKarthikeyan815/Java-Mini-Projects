package bean;

import java.util.List;

public class AirCargoDetails extends VehicleDetails{
    private  double airForce;

    public AirCargoDetails(int vehicleID, String vehicleName, int capacity, List<PackageDetails> packageDetails, double airForce) {
        super(vehicleID, vehicleName, capacity, packageDetails);
        this.airForce = airForce;
    }



    public double getAirForce() {
        return airForce;
    }

    public void setAirForce(double airForce) {
        this.airForce = airForce;
    }

    @Override
    public String toString() {
        return "AirCargoDetails{" +
                "vehicleID=" + getVehicleID() +
                ", vehicleName='" + getVehicleName() + '\'' +
                ", capacity=" + getCapacity() +
                ", packageDetails=" + getPackageDetails() +
                "airForce=" + airForce +
                '}';
    }
}
