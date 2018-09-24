package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class NearestOrderCommand extends Command {
    public static final String NAME = "NEAREST_ORDER_COMMAND";

    @Override
    public String execute(Controller controller) {
        controller.setNearest(true);
        return "Please, enter date in following format: 2018-09-24;15:09:09";
    }
}
