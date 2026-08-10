package Inter;

import Excep.InvalidVehicleException;
import Excep.VehicleCapacityException;
import bean.PackageDetails;
import bean.VehicleDetails;

import java.util.HashMap;
import java.util.List;

public interface ManageCargo {

    public void addPackageToVechile(PackageDetails packageDetails,int vechileID) throws VehicleCapacityException, InvalidVehicleException;

    public VehicleDetails fetchPackage(int packageID);
    public void deliverPackage(int packageID);
    public List<PackageDetails> deliveryPendingPackages();
    public HashMap<Integer, Integer> fetchUndeliveredPackages();

}
