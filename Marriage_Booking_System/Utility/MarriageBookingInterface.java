package utility;

import Bean.Applicant;
import Excep.ApplicantNotFound;

import java.util.List;
import java.util.Map;

public interface MarriageBookingInterface {
    public boolean addApplicant(Applicant a);
    public List<Applicant> findMatch(Applicant s) throws ApplicantNotFound;
    public boolean assignApplicant(int applicantId, Applicant a);
    public boolean dropProposal(int applicantid);
    public Map<String, Integer> findApplicantSummary();
}
