package Bean;

import java.util.Arrays;

public class Student {
    private long rollno;
    private String name;
    private String address;
    private String subject;
    private Integer[] marks=new Integer[6];

    public Student(long rollno, String name, String address, String subject, Integer[] marks) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
        this.subject = subject;
        this.marks = marks;
    }

    public long getRollno() {
        return rollno;
    }

    public void setRollno(long rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer[] getMarks() {
        return marks;
    }

    public void setMarks(Integer[] marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
