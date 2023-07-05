package com.techno.servletdemo.mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

	public static List<Student> getStudents() {
		
		// create an empty list
		List<Student> studentsList = new ArrayList<>();
		
		// add sample data
		studentsList.add(new Student("Ahmad", "Ali", "ahmad@techno-genes.com"));
		studentsList.add(new Student("Sameer", "Khan", "sameer@techno-genes.com"));
		studentsList.add(new Student("Qasim", "Hassan", "qasim@techno-genes.com"));
		
		// return the list
		return studentsList;
	}
}







