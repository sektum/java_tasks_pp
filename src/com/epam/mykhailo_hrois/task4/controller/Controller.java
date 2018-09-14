package com.epam.mykhailo_hrois.task4.controller;

import com.epam.mykhailo_hrois.task4.entities.Goods;

public class Controller {
    private Goods good;
    private String exception;

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
