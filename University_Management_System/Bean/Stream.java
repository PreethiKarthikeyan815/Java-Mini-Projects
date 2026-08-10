package Bean;

public class Stream {
    private String streamname;
    private  int modulescount;
    private int noofassignments;
    private  int noofassessments;

    public Stream(String streamname, int modulescount, int noofassignments, int noofassessments) {
        this.streamname = streamname;
        this.modulescount = modulescount;
        this.noofassignments = noofassignments;
        this.noofassessments = noofassessments;
    }

    public String getStreamname() {
        return streamname;
    }

    public void setStreamname(String streamname) {
        this.streamname = streamname;
    }

    public int getModulescount() {
        return modulescount;
    }

    public void setModulescount(int modulescount) {
        this.modulescount = modulescount;
    }

    public int getNoofassignments() {
        return noofassignments;
    }

    public void setNoofassignments(int noofassignments) {
        this.noofassignments = noofassignments;
    }

    public int getNoofassessments() {
        return noofassessments;
    }

    public void setNoofassessments(int noofassessments) {
        this.noofassessments = noofassessments;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "streamname='" + streamname + '\'' +
                ", modulescount=" + modulescount +
                ", noofassignments=" + noofassignments +
                ", noofassessments=" + noofassessments +
                '}';
    }
}
