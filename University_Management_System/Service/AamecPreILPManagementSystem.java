package Service;

import Bean.*;
import Excep.*;

import java.util.*;

public class AamecPreILPManagementSystem {

    private List<Faculty> faculties=new ArrayList<>();
    private List<Batch> batchs=new ArrayList<>();

    public boolean addFaculty(Faculty f){
        faculties.add(f);

        System.out.println();
        faculties.stream().forEach(System.out::println);
        System.out.println();
        return true;
    }

    public boolean addBatchToPreilp(Batch batch, List<Stream> list)throws BatchAlreadyExistExcepton
    {
        int f=0;
        for(Batch k: batchs){
            if(k.getBatchname().equals(batch.getBatchname())) {
                throw new  BatchAlreadyExistExcepton("Already Added in Batch");
            }
        }
        batch.setStreams(list);
        batchs.add(batch);
        System.out.println();
        batchs.stream().forEach(System.out::println);
        System.out.println();
        return true;
    }
   public String addSectionToBatch(int batchid, String secName, int secAssociateCount, String secStartdate, String secEndDate, String streamname)throws SectionAlreadyExistException, SectionStreamNotMatchedException {

        boolean flag=false;
        for( Batch k: batchs){
            if(k.getBatchid() == batchid){
                for(Section s: k.getSections()){
                    if(s.getSecName().equals(secName)){
                        throw new SectionAlreadyExistException("Section Already present");
                    }
                }
                for(Stream s: k.getStreams()){
                    if(s.getStreamname().equals(streamname)){
                        Section sec= new Section(secName, secAssociateCount, secStartdate,secEndDate, streamname, null);
                        k.getSections().add(sec);
                        flag=true;
                    }
                }
            }

        }
       if(!flag)
           throw new SectionStreamNotMatchedException("Invalid Straem and Section ");

       System.out.println();
       batchs.stream().forEach(System.out::println);
       System.out.println();

        return  "Section Added to batch";
   }
   public String tagFacultytoSection(int facultyid, String  batchname, String sectionname)throws FacultyAlreadyTaggedException, FacultyNotExistException{

        boolean flag=false;
        Faculty fac=null;
       for(Faculty f: faculties){
           if(f.getFacultyId()==facultyid){
               flag=true;
               fac=f;
               break;
           }
       }
       if(!flag)
           throw new FacultyNotExistException("Invalid faculty ID"+facultyid);
      for(Batch k: batchs){
          if(k.getBatchname().equals(batchname)){
              for(Section s: k.getSections()){
                  if(s.getSecName().equals(sectionname)){
                      if(s.getFaculty()!=null){
                          throw new FacultyAlreadyTaggedException("Already Faculty is Assigned to the Section"+sectionname);
                      }
                      else
                          s.setFaculty(fac);
                  }
              }
          }
      }

        return "Faculty Tagged";

   }
   public  List<Section> getAllSectionsTaggedtoBatch(String batchname){

        List<Section> secs=new ArrayList<>();

        for(Batch k: batchs){
            if(k.getBatchname().equals(batchname)){
                secs= k.getSections();
                break;
            }
        }
       Collections.sort(secs, (a,b)->Integer.compare(a.getSecAssociatecount(), b.getSecAssociatecount()));

        return secs;
   }
   public Map<String, Double> calculateTotalPerksBasedonFacultyType(){

        Map<String , Double> h=new HashMap<>();

        for(Faculty f: faculties){
            String faculty=f instanceof PermanentFaculty?"PermanentFaculty":"VisitingFaculty";
                    h.put(faculty, h.getOrDefault(faculty,0.0)+f.calculateExtraPerks());
        }
        return h;
   }
}
