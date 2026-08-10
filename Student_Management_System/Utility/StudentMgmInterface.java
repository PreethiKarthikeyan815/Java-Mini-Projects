package Utility;

import Bean.Student;
import Excep.StudentDoesntExist;

public interface StudentMgmInterface {

    public boolean addStudent(Student s);
    public  boolean deleteStudent(long rollNo)throws StudentDoesntExist;
    public void listStudents();
    public boolean updateStudent(long rollNo, Student std) throws StudentDoesntExist;
    public Student findTopper();



}
