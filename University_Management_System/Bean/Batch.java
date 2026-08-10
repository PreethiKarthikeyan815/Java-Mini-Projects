package Bean;

import java.util.ArrayList;
import java.util.List;

public class Batch {
    private int batchid;
    private  String batchname;
    private  String batchjoiningdate;
    private List<Section> sections=new ArrayList<>();
    private  List<Stream> streams= new ArrayList<>();

    public Batch(int batchid, String batchname, String batchjoiningdate, List<Section> sections, List<Stream> streams) {
        this.batchid=batchid;
        this.batchname = batchname;
        this.batchjoiningdate = batchjoiningdate;
        this.sections = new ArrayList<>();
        this.streams = new ArrayList<>();
    }

    public int getBatchid() {
        return batchid;
    }

    public void setBatchid(int batchid) {
        this.batchid = batchid;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public String getBatchjoiningdate() {
        return batchjoiningdate;
    }

    public void setBatchjoiningdate(String batchjoiningdate) {
        this.batchjoiningdate = batchjoiningdate;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchid=" + batchid +
                ", batchname='" + batchname + '\'' +
                ", batchjoiningdate='" + batchjoiningdate + '\'' +
                ", sections=" + sections +
                ", streams=" + streams +
                '}';
    }
}
