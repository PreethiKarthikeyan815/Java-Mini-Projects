package Bean;

public abstract class Faculty {
    private int facultyId;
    private String name;
    private int experience;
    private String gender;

    public abstract double calculateExtraPerks();

    public Faculty(int facultyId, String name, int experience, String gender) {
        this.facultyId = facultyId;
        this.name = name;
        this.experience = experience;
        this.gender = gender;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", gender='" + gender + '\'' +
                '}';
    }
}
