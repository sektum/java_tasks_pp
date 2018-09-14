package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.shop.Warehouse;

public class StartCommand extends Command {
    public static final String NAME = "START_COMMAND";

    @Override
    public String execute(Controller controller) {
        StringBuilder result = new StringBuilder();
        result.append("Welcome to our shop. What do you want?");
        result.append(System.lineSeparator());
        result.append(Warehouse.getInstance().toString());
        result.append(System.lineSeparator());
        result.append(CommandList.getCommandList().toString());
        return result.toString();
    }
}
