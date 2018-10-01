package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.shop.Warehouse;

public class SetGoodCommand extends Command {
    public static final String NAME = "SET_GOOD_COMMAND";

    @Override
    public String execute(Controller controller, String[] arguments) {
        int id = Integer.valueOf(arguments[1]) - 1;
        return "You are on Good: " + Warehouse.getGoodsList().get(id).toString();
    }
}
