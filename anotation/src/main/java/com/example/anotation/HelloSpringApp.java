package com.example.anotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		
		ClassPathXmlApplicationContext context = 
						new ClassPathXmlApplicationContext("applicationContext.xml");
						
		// retrieve bean from spring container
		Person thePerson =  context.getBean("person", Person.class);

		System.out.println("Person Id = "+thePerson.getPersonId());
		// call methods on the bean
		System.out.println("First Name = "+thePerson.getFirsName());
				
		// let's call our new method for fortunes
		System.out.println("Last Name = "+thePerson.getLastName());

		System.out.println("Brain = ");
		thePerson.getTheBrain().thinking(); // person -> brain --> thinking()
		thePerson.getTheBrain().display();  //person --> brain --> display()

		System.out.println("Heart = ");
		thePerson.getTheHeart().pumping();
		thePerson.getTheHeart().display();



		// close the context
		context.close();
	}

}
