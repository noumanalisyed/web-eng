package org.example;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Student> studentList;
    List<Course> courseList;
    public Main(){
        studentList = new ArrayList<Student>();
        courseList = new ArrayList<Course>();
        Student student1 = new Student(100,"Ahmad","Lahore",new Date((2001-1900),11,10));
        Student student2 = new Student(101,"Kashif","Lahore",new Date((2000-1900),8,19));
        Student student3 = new Student(102,"Zahid","Lahore",new Date((2002-1900),5,14));
        Course course1 = new Course(1,"CS-101","Fundamentals of Programming","Fundamentals of Programming");
        Course course2 = new Course(2,"CS-201","Object Oriented Programming","Object Oriented Programming");
        Course course3 = new Course(3,"CS-301","Data Structures & Algorithms","Data Structures & Algorithms");

        Registration registration1 = new Registration(1,new Date(),"Spring 2023");
        registration1.setCourse(course1);
        registration1.setStudent(student1);
        course1.addCourseRegistration(registration1);
        student1.addStudentRegistration(registration1);

        Registration registration2 = new Registration(2,new Date(),"Spring 2023");
        registration2.setCourse(course2);
        registration2.setStudent(student1);
        course2.addCourseRegistration(registration2);
        student1.addStudentRegistration(registration2);



        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);

        System.out.println(registration1);
        System.out.println(registration2);
    }
    public static void main(String[] args) {
        Main main1 = new Main();
    }
}
