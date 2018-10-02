package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class FiveLastGoodsCommand extends Command {
    public static final String NAME = "Show five last goods has been added to basket";

    @Override
    public String execute(Controller controller, String[] arguments) {
        return controller.getBasket().printFiveLast();
    }

}
