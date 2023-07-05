package com.example.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@PropertySource("classpath:person.properties")
@Component
public class Person {
    @Value("${firstName}")
    private String firsName;

    @Value("${lastName}")
    private String lastName;

    @Value("${personId}")
    private String personId;

    @Autowired
    private Brain theBrain;
    @Autowired
    private Heart theHeart;

/*
    public Person(Brain theBrain, Heart theHeart) {
        this.theBrain = theBrain;
        this.theHeart = theHeart;
    }
*/

    public Person() {
    }

    public Person(String firsName, String lastName, String personId) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.personId = personId;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personId='" + personId + '\'' +
                '}';
    }

    public Brain getTheBrain() {
        return theBrain;
    }


    public void setTheBrain(Brain theBrain) {
        this.theBrain = theBrain;
    }

    public Heart getTheHeart() {
        return theHeart;
    }


    public void setTheHeart(Heart theHeart) {
        this.theHeart = theHeart;
    }

    @PostConstruct
    public void init(){
        System.out.println("Initializing ...........");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Shutting Down ...........");
    }
}
