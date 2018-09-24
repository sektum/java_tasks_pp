package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class BetweenSetFirstCommand extends Command {
    public static final String NAME = "SET_FIRST_DATE_COMMAND";

    @Override
    public String execute(Controller controller) {
        return "Please, enter SECOND date in the same format";
    }
}
