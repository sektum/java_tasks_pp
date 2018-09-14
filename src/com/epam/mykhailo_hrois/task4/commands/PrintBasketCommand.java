package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class PrintBasketCommand extends Command {
    public static final String NAME = "PRINT_BASKET_COMMAND";

    @Override
    public String execute(Controller controller) {
        return basket.toString();
    }
}
