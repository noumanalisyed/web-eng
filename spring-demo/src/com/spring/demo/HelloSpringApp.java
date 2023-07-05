package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class HelloSpringApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		// load the spring configuration file
		
		ClassPathXmlApplicationContext context = 
						new ClassPathXmlApplicationContext("applicationContext.xml");

		if(context != null) {
			// retrieve bean from spring container
			CricketCoach theCricketCoach = (CricketCoach) context.getBean("myCricketCoach", CricketCoach.class);


			// call methods on the bean
			System.out.println(theCricketCoach.getDailyWorkout());
			System.out.println(theCricketCoach.getInformation());
			System.out.println(theCricketCoach.getDailyFortune());
			System.out.println(theCricketCoach.getEmailAddress());
			System.out.println(theCricketCoach.getTeam());

			// retrieve bean from spring container
			Coach theCoach = (BaseballCoach) context.getBean("myBaseBallCoach", Coach.class);

			// call methods on the bean
			System.out.println(theCoach.getDailyWorkout());
			System.out.println(theCoach.getInformation());
			System.out.println(theCoach.getDailyFortune());
			// let's call our new method for fortunes
			System.out.println(theCoach.getDailyFortune());

			// close the context
		}
		else {
			context.close();
			throw new FileNotFoundException("Application Context File not Found !!!");

		}
	}

}
