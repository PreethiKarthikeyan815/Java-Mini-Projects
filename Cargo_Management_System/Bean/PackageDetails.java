package bean;

public class PackageDetails {

    private int packageID;
    private String status;

    public PackageDetails(int packageID, String status) {
        this.packageID = packageID;
        this.status = status;
    }

    public int getPackageID() {

        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PackageDetails{" +
                "packageID=" + packageID +
                ", status='" + status + '\'' +
                '}';
    }
}
