package com.spring.dependency.dependency_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

public class Person {

    private String firsName;

    private String lastName;

    private String personId;

    private Brain theBrain;
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

    public void init(){
        System.out.println("Initializing ...........");
    }
    public void destroy(){
        System.out.println("Shutting Down ...........");
    }
}
