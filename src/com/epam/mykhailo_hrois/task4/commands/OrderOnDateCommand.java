package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class OrderOnDateCommand extends Command {
    public static final String NAME = "ORDER_ON_DATE_COMMAND";

    @Override
    public String execute(Controller controller) {
        controller.setOrdering(true);
        return "Please, enter date in following format: 2018-09-24;15:09:09";
    }
}
