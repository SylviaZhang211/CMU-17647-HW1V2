package com.example.hw1v2.utils;

import java.util.Set;

public class Validation {

    public static boolean checkPrice(double price){
        return !(Double.toString(price)).matches("\\d+(\\.\\d{1,2})?");
    }

   public static boolean checkState(String state){
        Set<String> validStates = Set.of("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        return validStates.contains(state.toUpperCase());

    }

//    public boolean checkEmail(String userId){
//        Pattern pattern = Pattern.compile("^(.+)@(\\\\S+)$");
//        Matcher matcher = pattern.matcher(userId);
//        return !matcher.matches();
//    }


}
