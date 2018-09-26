package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class ExitCommand extends Command {
    public static final String NAME = "EXIT_COMMAND";

    @Override
    public String execute(Controller controller, String[] strings) {
        controller.setSession(false);
        return "Have a good day!";
    }
}
