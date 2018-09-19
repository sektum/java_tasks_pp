package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class StartCommand extends Command {
    public static final String NAME = "START_COMMAND";

    @Override
    public String execute(Controller controller) {
        StringBuilder result = new StringBuilder();
        result.append("Welcome to our shop. What would you like?");
        result.append(System.lineSeparator());
        result.append(new DisplayGoodsCommand().execute(controller));
        result.append(System.lineSeparator());
        result.append(new PrintBasketCommand().execute(controller));
        return result.toString();
    }
}
