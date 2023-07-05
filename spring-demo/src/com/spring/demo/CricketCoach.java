package com.spring.demo;

public class CricketCoach implements Coach{
    private String emailAddress;
    private String team;
    private FortuneService fortuneService;

    public CricketCoach() {
    }
    // construcor injection
    public CricketCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
    //setter injection
    public void setCricketCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Do Bowling practise for 1 hour";
    }
    @Override
    public String getDailyFortune() {
        // use my fortuneService to get a fortune
        return fortuneService.getFortune();
    }
    @Override
    public String getInformation() {
        return "Hello Cricket Coach";
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
