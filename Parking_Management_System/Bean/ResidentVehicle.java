package Bean;

public class ResidentVehicle extends Vehicle{

        private int flatNumber;
        private boolean parkinngStatus;

        public ResidentVehicle(String regNumber, String ownerName, long mobileNumber, int flatNumber, boolean parkinngStatus) {
            super(regNumber, ownerName, mobileNumber);
            this.flatNumber = flatNumber;
            this.parkinngStatus = parkinngStatus;
        }

        public int getFlatNumber() {
            return flatNumber;
        }

        public void setFlatNumber(int flatNumber) {
            this.flatNumber = flatNumber;
        }

        public boolean isParkinngStatus() {
            return parkinngStatus;
        }

        public void setParkinngStatus(boolean parkinngStatus) {
            this.parkinngStatus = parkinngStatus;
        }

        @Override
        public String toString() {
            return "ResidentVehicle{" +
                    "flatNumber=" + flatNumber +
                    ", parkinngStatus=" + parkinngStatus +
                    '}';
        }
    }


