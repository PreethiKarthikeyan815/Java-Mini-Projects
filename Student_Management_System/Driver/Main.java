package Test;

import Bean.Student;
import Excep.StudentDoesntExist;
import Service.StudentManagement;

import java.util.Scanner;

public class Main {
    static long rollNo=1234;
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int ch; long rno;
        StudentManagement sm=new StudentManagement();
        do{
            System.out.println("Student Managemnet System");
            System.out.println("1---> Add Student");
            System.out.println("2---> Delete Student");
            System.out.println("3---> List Students");
            System.out.println("4---> Update Student");
            System.out.println("5---> FindTopper");
            System.out.println("6---> Exit");
            System.out.println("Enter Your coice");
            ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Add New Student");
                    System.out.println("Enter Name:");
                    String name=sc.next();
                    System.out.println("Enter Address:");
                    String address=sc.next();
                    System.out.println("Enter Subject:");
                    String sub=sc.next();
                    Integer[] a=new Integer[6];
                    for(int i=0;i<6;i++)
                    {
                        System.out.println("Enter mark"+(i+1)+":");
                        a[i]=sc.nextInt();
                    }
                    Student s=new Student(rollNo,name, address, sub, a );
                    System.out.println("Whether the Stusent added to the List ?: "+sm.addStudent(s));
                    System.out.println("Your RollNo is:"+rollNo);
                    rollNo++;
                    System.out.println();
                    break;
                case 2:
                    try{
                    System.out.println("Delete Student:-");
                    System.out.println("Enter Student RollNo::");
                    rno= sc.nextLong();
                    System.out.println("Whether Student Deleted or not? : "+sm.deleteStudent(rno));
                    rollNo--;
                    }catch(StudentDoesntExist sde){
                        System.out.println(sde);
                    }
                    break;
                case 3:
                    System.out.println("Display Students");
                    sm.listStudents();
                    System.out.println();
                    break;
                case 4:
                    try {
                        System.out.println("Update Student");
                        System.out.println("Enter RollNo:");
                        rno = sc.nextLong();
                        System.out.println("Enter name:");
                        String n = sc.next();
                        System.out.println("Enter Address:");
                        String ad = sc.next();
                        System.out.println("Enter Subject:");
                        String su = sc.next();
                        Integer[] b = new Integer[6];
                        for (int i = 0; i < 6; i++) {
                            System.out.println("Enter mark " + (i + 1) + ": ");
                            b[i] = sc.nextInt();
                        }
                        Student ss = new Student(rno, n, ad, su, b);
                        System.out.println("Whether student updated ?:" + sm.updateStudent(rno, ss));
                    }catch(StudentDoesntExist sde){
                        System.out.println(sde);
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Find Topper");
                    System.out.println("Topper:"+sm.findTopper());
                    System.out.println();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid Choice:-");

            }
        }while (ch!=6);
    }
}
