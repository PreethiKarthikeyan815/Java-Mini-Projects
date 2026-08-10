package Bean;

public class Applicant extends Person {

    private Person partner;

    public Applicant(int applicantId, String name, int age, String sex, Person partner) {
        super(applicantId, name, age, sex);

        this.partner = partner;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + getApplicantId()+
                ", partner=" + partner +
                '}';
    }
}

