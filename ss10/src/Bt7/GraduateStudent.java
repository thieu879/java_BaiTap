package Bt7;

public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisorName;

    public GraduateStudent(double gpa, String id, String name, String researchTopic, String supervisorName) {
        super(gpa, id, name);
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }
    @Override
    public String getDetails() {
        return super.getDetails() + " || " + researchTopic + " || " + supervisorName;
    }

}
