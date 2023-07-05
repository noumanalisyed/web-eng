package com.student.studentregistration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utility {
    private String countryNames [] = {
                "Afghanistan","Australia","Bahrain","Pakistan","Singapore",
                "UAE", "United Kingdom  (UK)", "United States (USA)"};

    private ArrayList<String> countryList = new ArrayList<String>();

    public Utility(){
        loadData();
    }

    public void loadData(){
        for (int i = 0; i < countryNames.length; i++) {
            countryList.add(countryNames[i]);
        }
    }
    public List<String> getCountryList(){
        return countryList;
    }
    public String getCountry(int index){
        return countryList.get(index);
    }
    public int getLenght(){
        return countryList.size();
    }
}
