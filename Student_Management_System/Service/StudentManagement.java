package Service;

import Bean.Student;
import Excep.StudentDoesntExist;
import Utility.StudentMgmInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManagement implements StudentMgmInterface {

    List<Student> stud=new ArrayList<>();

    @Override
    public boolean addStudent(Student s) {

        if(stud.size()>=10)
            return false;
        stud.add(s);
        return true;
    }

    @Override
    public boolean deleteStudent(long rollNo) throws StudentDoesntExist {

        Iterator<Student> s=stud.iterator();
        while(s.hasNext()){
            if(s.next().getRollno()==rollNo){
                s.remove();
                return true;
            }

        }
       throw new StudentDoesntExist("Invalid RollNo");

    }

    @Override
    public void listStudents() {
        stud.stream().forEach(System.out::println);

    }

    @Override
    public boolean updateStudent(long rollNo, Student std) throws StudentDoesntExist {

        for (Student s: stud){
            if(s.getRollno()==rollNo) {
                s.setName(std.getName());
                s.setAddress(std.getAddress());
                s.setMarks(std.getMarks());
                s.setSubject(std.getSubject());

                return true;
            }
        }


       throw new StudentDoesntExist("Invalid RollNo-"+rollNo);
    }

    @Override
    public Student findTopper() {
        int sum ; double max=0; Student st=null;
        for(Student s: stud)
        {
            sum=0;
            for(Integer k:  s.getMarks()){
               sum=sum+k;
            }
            if(sum>max) {
                max = sum;
                st=s;
            }
        }
        return st ;
    }
}
