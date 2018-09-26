package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class StartCommand extends Command {
    public static final String NAME = "START_COMMAND";

    @Override
    public String execute(Controller controller, String[] strings) {
        controller.setSession(true);
        StringBuilder result = new StringBuilder();
        result.append("Welcome to our shop. What would you like?");
        result.append(System.lineSeparator());
        result.append("Type \"help\" to see the command list.");
        result.append(System.lineSeparator());
        result.append(System.lineSeparator());
        result.append(new DisplayGoodsCommand().execute(controller, strings));
        result.append(System.lineSeparator());
        result.append(new PrintBasketCommand().execute(controller, strings));
        return result.toString();
    }
}
