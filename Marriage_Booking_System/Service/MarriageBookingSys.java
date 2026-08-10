package service;

import Bean.Applicant;
import Bean.Person;
import Excep.ApplicantNotFound;
import utility.MarriageBookingInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarriageBookingSys implements MarriageBookingInterface {
    List<Applicant> applicant =new ArrayList<>();

    @Override
    public boolean addApplicant(Applicant a) {

        if(applicant.size()>=10)
            return false;
        applicant.add(a);
        for(Applicant k: applicant)
            System.out.println(k);
        return true;

    }

    @Override
    public List<Applicant> findMatch(Applicant s) throws ApplicantNotFound {

        List<Applicant> ap=new ArrayList<>();
        boolean f=false;
        for(Applicant k: applicant)
            if(s.getApplicantId()==k.getApplicantId()){
                f=true;
                s=k;
            }
        if(!f)
            throw new ApplicantNotFound("Invalid Apllicant Id ");


        for(Applicant k: applicant){
            if(!(k.getSex().equals(s.getSex()))&& k.getAge() >= s.getAge()) {
                f=true;
                ap.add(k);
            }
        }
        if(!f)
            throw new ApplicantNotFound("No Match Found");
        return ap;
    }

    @Override
    public boolean assignApplicant(int applicantId, Applicant a) {

         boolean f=false;
        for(Applicant k:applicant){
            if(k.getApplicantId()==a.getApplicantId()){
                f=true;
                a=k;
                break;
            }
        }
        if(!f)
            return false;
        for(Applicant k: applicant){
            if(k.getApplicantId()==applicantId){
                k.setPartner(a);
                a.setPartner(k);

                System.out.println("ApplicantId:"+k.getApplicantId());
                System.out.println("Name: "+k.getName());
                System.out.println("Age: "+k.getAge());
                System.out.println("Sex:"+ k.getSex());
                System.out.println();
                System.out.println("Partner Details");

                System.out.println("Name: "+k.getPartner().getName());
                System.out.println("Age: "+k.getPartner().getAge());
                System.out.println("Sex:"+ k.getPartner().getSex());
                System.out.println();

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean dropProposal(int applicantid) {
        boolean f=false;
        for(Applicant k:applicant){
            if(k.getApplicantId()==applicantid){
                int id=k.getPartner().getApplicantId();
                k.setPartner(null);


                for(Applicant s: applicant)
                    if(s.getApplicantId()==id) {
                        s.setPartner(null);
                        f=true;
                        break;
                    }
                if(f)
                return true;
            }

        }
        return false;
    }
    public Map<String, Integer> findApplicantSummary(){
        Map<String , Integer> h=new HashMap<>();

        for(Applicant k: applicant){
            if(k.getPartner()==null)
                h.put(k.getSex(),h.getOrDefault(k.getSex(),0)+1);

        }
        return h;
    }

}
