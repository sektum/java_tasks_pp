package com.epam.mykhailo_hrois.task4.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
    public static Long convertDate(String enteredDate) {
        String exp = "^([0-9]{4})-([0-1][0-9])-([0-3][0-9]);([0-1][0-9]|[2][0-3]):([0-5][0-9]):([0-5][0-9])$";
        if (enteredDate.matches(exp)) {
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-mm-dd;HH:mm:ss");
            try {
                Date date = simpleDate.parse(enteredDate);
                return date.getTime();
            } catch (ParseException e) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
