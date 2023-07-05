package org.example;
import java.util.Date;
public class Registration {
    private int registrationId;
    private Date registrationDate;
    private String semester;
    private Student student;
    private Course course;

    public Registration() {
    }

    public Registration(Date registrationDate, String semester) {
        this.registrationDate = registrationDate;
        this.semester = semester;
    }

    public Registration(int registrationId, Date registrationDate, String semester) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.semester = semester;
    }

    public Registration(int registrationId, Date registrationDate, String semester, Student student, Course course) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.semester = semester;
        this.student = student;
        this.course = course;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId=" + registrationId +
                ", registrationDate=" + registrationDate +
                ", semester='" + semester + '\'' +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
