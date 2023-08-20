package com.techno.jsp;
import com.techno.jsp.Student;
public class FunStudent {

	public static String makeItLower(Student data) {

		return "First Name : "+data.getFirstName().toLowerCase()
				+" , Last Name : "+data.getLastName().toLowerCase()
				+" , Address : "+data.getAddress().toLowerCase();
	}
	public static String makeItUpper(Student data) {
		return "First Name : "+data.getFirstName().toUpperCase()
				+" , Last Name : "+data.getLastName().toUpperCase()
				+" , Address : "+data.getAddress().toUpperCase();
	}
	
}
