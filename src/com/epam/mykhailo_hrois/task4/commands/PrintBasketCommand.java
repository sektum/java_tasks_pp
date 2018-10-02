package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class PrintBasketCommand extends Command {
    public static final String NAME = "Show goods in your basket";

    @Override
    public String execute(Controller controller, String[] arguments) {
        return controller.getBasket().toString();
    }
}
