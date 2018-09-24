package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class BetweenDatesCommand extends Command {
    public static final String NAME = "BETWEEN_DATES_COMMAND";

    @Override
    public String execute(Controller controller) {
        controller.setBetween(true);
        return "Please, enter FIRST date in following format: 2018-09-24;15:09:09";
    }
}
