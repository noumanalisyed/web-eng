package com.spring.demo;

import java.util.Random;

public class RandomFortuneService implements FortuneService{

    String messages[] ={"You will win lottery today!!",
                        "Today you will take 5 wickets",
                        "Today your knee will get hurt",
                        "Lets play I will bring a friend"};
    @Override
    public String getFortune() {
        return messages[getRandomNo()];
    }
    private int getRandomNo(){
        Random r = new Random();
        int x = r.nextInt(4);
        return x;
    }
}
