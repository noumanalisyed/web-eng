package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class Student {
    private int studentId;
    private String name;
    private String address;
    private Date dateOfBirth;
    private List<Registration> registrationList;

    public Student() {
        studentId = 0;
        name = "";
        address = "";
        registrationList = new ArrayList<Registration>();
    }

    public Student(String name, String address, Date dateOfBirth) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        registrationList = new ArrayList<Registration>();
    }

    public Student(int studentId, String name, String address, Date dateOfBirth) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        registrationList = new ArrayList<Registration>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
    public void addStudentRegistration(Registration registration){
        registrationList.add(registration);
    }
    public void removeStudentRegistration(Registration registration){
        registrationList.remove(registration);
    }

}
