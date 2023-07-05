package com.example.anotation;

import org.springframework.stereotype.Component;

@Component
public class Heart implements BodyPart{

    public void pumping(){
        System.out.println("Heart -- Pumping ...");
    }
    public void display() {
        System.out.println("I am a Heart ...");
    }

}
