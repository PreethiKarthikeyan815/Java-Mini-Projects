package Test;

import Bean.Applicant;
import Bean.Person;
import Excep.ApplicantNotFound;

import service.MarriageBookingSys;

import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int app_id=1234;
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        MarriageBookingSys mbs=new MarriageBookingSys();

        int ch, id, age,ch1; String sex,name;
        do{
            System.out.println("Marriage Booking System:-");
            System.out.println("1--->Add Aplicant");
            System.out.println("2--->FindMatch");
            System.out.println("3--->Assign Applicant");
            System.out.println("4--->Drop Proposal");
            System.out.println("5--->Find Applicant Summary");
            System.out.println("6--->Exit ");
            System.out.println("Enter Your Choice:");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Add Applicant ");
                    System.out.println("Enter name:");
                    name=sc.next();
                    System.out.println("Enter age:");
                    age=sc.nextInt();
                    System.out.println("Enter sex:\n1-->Female\n2-->Male");
                    ch1=sc.nextInt();
                    if(ch1==1)
                        sex="Female";
                    else
                        sex="Male";
                   // Person p=new Person(app_id, name, age, sex);
                    Applicant a=new Applicant(app_id, name,age, sex, null);
                    System.out.println("Whetehr Apllicant added ?: "+mbs.addApplicant(a));
                    System.out.println();
                    System.out.println("Your Applicant Id is:"+app_id++);
                    System.out.println();
                    break;
                case 2:
                    try {
                        System.out.println("Find match");
                        System.out.println("Enter Applicant Id where you need to add partner:--");
                        id = sc.nextInt();
                        Applicant a1 = new Applicant(id, null, 0, null, null);
                        List<Applicant> list=mbs.findMatch(a1);
                        for(Applicant s: list){
                            System.out.println("ApplicantId:"+s.getApplicantId());
                            System.out.println("Name: "+s.getName());
                            System.out.println("Age: "+s.getAge());
                            System.out.println("Sex:"+ s.getSex());
                            System.out.println();


                        }

                        System.out.println();

                    }catch(ApplicantNotFound anf){
                        System.out.println(anf);
                    }
                    break;
                case 3:
                    System.out.println("Assign Applicant");
                    System.out.println("Enter Applicant Id where you need to add partner:--");
                     id= sc.nextInt();

                    System.out.println("Enter Applicant Id of partener:--");
                    int aid= sc.nextInt();

                    Applicant a2=new Applicant(aid,null, 0, null, null);
                    System.out.println("Whether Applicant Assigned :? "+mbs.assignApplicant(id, a2));

                    System.out.println();
                    break;
                case 4:
                    System.out.println("Cancel Proposal");
                    System.out.println();
                    System.out.println("Enter ApplicantId:");
                    id= sc.nextInt();
                    System.out.println("Whether the proposal Dropped?: "+mbs.dropProposal(id));
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Find Applicant Summary");
                    Map<String, Integer> h=mbs.findApplicantSummary();
                    System.out.println();
                    for(Map.Entry<String,Integer> entry :h.entrySet() ){
                        System.out.println(entry.getKey()+"  -  "+entry.getValue());
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid Choice");
            }


        }while(ch!=6);
    }
}
