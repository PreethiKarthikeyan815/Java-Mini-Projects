package Test;

import Bean.*;
import Excep.*;
import Service.AamecPreILPManagementSystem;

import java.util.*;

public class Main {
    public static int  b_id=1234;
    public static int  f_id=5001;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int ch, mid;
        String name, date;
        AamecPreILPManagementSystem aamec=new AamecPreILPManagementSystem();
        do{
            System.out.println("AAMEC PreILP Management System");
            System.out.println("1---> Add Faculty");
            System.out.println("2---> Add BatchToPreILP");
            System.out.println("3---> Add Section To Batch");
            System.out.println("4---> Add Faculty to Section");
            System.out.println("5---> Add All Section Tagged To Batch");
            System.out.println("6---> Add Calculate Total Perks");
            System.out.println("7---> Exit");
            System.out.println("Enter Your choice:");
            ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Add Faculty");
                    System.out.println();
                    System.out.println("Enter Faculty name:");
                    name= sc.next();
                    System.out.println("Enter Experience:");
                    int ex= sc.nextInt();
                    System.out.println("Enter Gender:");
                    String gender=sc.next();
                    System.out.println("Enter Faculty Type:\n1--->VistingFaculty\n2--->PermanentFaculty");
                    int type= sc.nextInt();
                    double amt;
                    if(type==1){
                        System.out.println("Enter Training Duration(Days):");
                        int td=sc.nextInt();
                        System.out.println("Enter Extra Allowance:");
                        amt=sc.nextDouble();
                        VisitingFaculty vf=new VisitingFaculty(f_id, name,ex, gender, td, amt);
                        aamec.addFaculty(vf);
                    }
                    else{
                        System.out.println("Experience Bonus:");
                        amt=sc.nextDouble();
                        PermanentFaculty pf=new PermanentFaculty(f_id, name, ex, gender,amt);
                        aamec.addFaculty(pf);
                    }
                    System.out.println("Your Faculty Id :"+f_id++);
                    System.out.println();
                    break;
                case 2:
                    try {
                        System.out.println("Add Batch to ILP");
                        System.out.println("Enter Batch Name:");
                        name = sc.next();
                        System.out.println("Enter batch JoiningDate:");
                        date = sc.next();
                        System.out.println("Enter Stream Details:-");
                        System.out.println();
                        List<Stream> st = new ArrayList<>();
                        System.out.println("Enter No Of Streams:");
                        int sno = sc.nextInt();
                        for (int i = 0; i < sno; i++) {
                            System.out.println("Enter Stream name:");
                            String sname = sc.next();
                            System.out.println("Enter Modules Count (int):");
                            int c = sc.nextInt();
                            System.out.println("Enter No Of Assignments:");
                            int ano = sc.nextInt();
                            System.out.println("Enter No Of Assesments");
                            int asno = sc.nextInt();
                            Stream s = new Stream(sname, c, ano, asno);
                            st.add(s);
                        }
                        Batch b = new Batch(b_id, name, date, null, null);
                        System.out.println("Whether batch Added ?: " + aamec.addBatchToPreilp(b, st));
                        System.out.println("Your Batch Id:"+b_id++);
                        System.out.println();
                    }catch(BatchAlreadyExistExcepton bae){
                        System.out.println(bae);
                    }

                    break;

                case 3:
                    try {
                        System.out.println();
                        System.out.println("Add Section To  Batch");
                        System.out.println("Enter Batch Id:");
                        mid = sc.nextInt();
                        System.out.println("Section Details");
                        System.out.println("Enter Section Name:");
                        name = sc.next();
                        System.out.println("Enter Section Associate Count:");
                        int sec_c = sc.nextInt();
                        System.out.println("Enter sec Start Date:");
                        String sdate = sc.next();
                        System.out.println("Enter sec End Date:");
                        String edate = sc.next();
                        System.out.println("Enter Stream Nmae:");
                        String strm_name = sc.next();
                        System.out.println("Whether Section Added To Batch: " + aamec.addSectionToBatch(mid, name, sec_c, sdate, edate, strm_name));
                    }catch (SectionAlreadyExistException sae){
                        System.out.println(sae);
                    }catch (SectionStreamNotMatchedException ssnm){
                        System.out.println(ssnm);
                    }
                    System.out.println();
                    break;
                case 4:
                    try {
                        System.out.println();
                        System.out.println("Tag Facuty To Section");
                        System.out.println();
                        System.out.println("Enter faculty id:");
                        mid = sc.nextInt();
                        System.out.println("Enter Batch Name:");
                        name = sc.next();
                        System.out.println("Enter Section Name:");
                        String s_name = sc.next();
                        System.out.println("Added? " + aamec.tagFacultytoSection(mid, name, s_name));
                    }catch (FacultyAlreadyTaggedException fat){
                        System.out.println(fat);
                    }catch (FacultyNotExistException fne){
                        System.out.println(fne);
                    }
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Get All Sections:");
                    System.out.println();
                    System.out.println("Enter Batch Name:");
                    name= sc.next();
                    List<Section> l= aamec.getAllSectionsTaggedtoBatch(name);
                    System.out.println();
                    l.stream().forEach(System.out::println);
                    System.out.println();
                    break;
                case 6 :
                    System.out.println();
                    System.out.println("Calculate Perks Of Faculties");
                    System.out.println();
                    Map<String, Double> h=new HashMap<>();
                     h=aamec.calculateTotalPerksBasedonFacultyType();

                    for(Map.Entry<String , Double> k: h.entrySet()){
                        System.out.println(k.getKey()+"="+k.getValue());
                    }
                    break;
                case 7:
                    break;

                    default:
                        System.out.println("Invalid Choice");


            }

        }while(ch!=7);
    }
}
