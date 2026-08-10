package Bean;

public class PermanentFaculty extends Faculty {
    private double experiencebonus;



    public PermanentFaculty(int facultyId, String name, int experience, String gender, double experiencebonus) {
        super(facultyId, name, experience, gender);
        this.experiencebonus = experiencebonus;
    }

    @Override
    public double calculateExtraPerks() {
        if(getExperience()<=3)
            return 0;
        double extraperks=getExperience()*experiencebonus;
        return extraperks;
    }
    public double getExperiencebonus() {
        return experiencebonus;
    }

    public void setExperiencebonus(double experiencebonus) {
        this.experiencebonus = experiencebonus;
    }

    @Override
    public String toString() {
        return "PermanentFaculty{" +
                "experiencebonus=" + experiencebonus +
                '}';
    }
}
