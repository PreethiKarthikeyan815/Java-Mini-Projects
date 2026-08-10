package Bean;

public class VisitingFaculty extends Faculty{
    private int trainingduration;
    private double extraAllowance;

    public VisitingFaculty(int facultyId, String name, int experience, String gender, int trainingduration, double extraAllowance) {
        super(facultyId, name, experience, gender);
        this.trainingduration = trainingduration;
        this.extraAllowance = extraAllowance;
    }
   // perks overriden
    @Override
    public double calculateExtraPerks() {
        double extraperks=trainingduration*extraAllowance;
        return extraperks;
    }

    public int getTrainingduration() {
        return trainingduration;
    }

    public void setTrainingduration(int trainingduration) {
        this.trainingduration = trainingduration;
    }

    public double getExtraAllowance() {
        return extraAllowance;
    }

    public void setExtraAllowance(double extraAllowance) {
        this.extraAllowance = extraAllowance;
    }

    @Override
    public String toString() {
        return "VisitingFaculty{" +
                "trainingduration=" + trainingduration +
                ", extraAllowance=" + extraAllowance +
                '}';
    }
}
