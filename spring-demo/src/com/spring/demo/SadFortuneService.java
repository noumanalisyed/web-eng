package com.spring.demo;

public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Today is your unlucky day";
    }
}
