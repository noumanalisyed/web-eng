package org.example;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseCode;
    private String name;
    private String description;
    private List<Registration> registrationList;

    public Course() {
        courseId = 0;
        courseCode="";
        name="";
        description="";
        registrationList = new ArrayList<Registration>();
    }

    public Course(String courseCode, String name, String description) {
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        registrationList = new ArrayList<Registration>();
    }

    public Course(int courseId, String courseCode, String name, String description) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        registrationList = new ArrayList<Registration>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public void addCourseRegistration(Registration registration){
        registrationList.add(registration);
    }
    public void removeCourseRegistration(Registration registration){
        registrationList.remove(registration);
    }
}
