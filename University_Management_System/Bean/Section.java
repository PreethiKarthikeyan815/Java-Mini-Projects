package Bean;

public class Section {
    private String secName;
    private int secAssociatecount;
    private String secStartdate;
    private  String secEndDate;
    private  String streamname;
    private Faculty faculty;

    public Section(String secName, int secAssociatecount, String secStartdate, String secEndDate, String streamname, Faculty faculty) {
        this.secName = secName;
        this.secAssociatecount = secAssociatecount;
        this.secStartdate = secStartdate;
        this.secEndDate = secEndDate;
        this.streamname = streamname;
        this.faculty = faculty;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public int getSecAssociatecount() {
        return secAssociatecount;
    }

    public void setSecAssociatecount(int secAssociatecount) {
        this.secAssociatecount = secAssociatecount;
    }

    public String getSecStartdate() {
        return secStartdate;
    }

    public void setSecStartdate(String secStartdate) {
        this.secStartdate = secStartdate;
    }

    public String getSecEndDate() {
        return secEndDate;
    }

    public void setSecEndDate(String secEndDate) {
        this.secEndDate = secEndDate;
    }

    public String getStreamname() {
        return streamname;
    }

    public void setStreamname(String streamname) {
        this.streamname = streamname;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Section{" +
                "secName='" + secName + '\'' +
                ", secAssociatecount=" + secAssociatecount +
                ", secStartdate='" + secStartdate + '\'' +
                ", secEndDate='" + secEndDate + '\'' +
                ", streamname='" + streamname + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
