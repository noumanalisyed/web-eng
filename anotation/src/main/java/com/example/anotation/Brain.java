package com.example.anotation;

import org.springframework.stereotype.Component;

@Component
public class Brain implements BodyPart{
    public void thinking(){
        System.out.println("Brain -- Thinking ...");
    }
    public void display() {
        System.out.println("I am a Brain .....");
    }
}
