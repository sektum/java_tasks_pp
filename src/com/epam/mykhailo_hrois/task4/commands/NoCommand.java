package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class NoCommand extends Command {
    public static final String NAME = "NO_COMMAND";

    @Override
    public String execute(Controller controller) {
        return "There is no such command \n" + CommandList.getCommandList().get(PrintCommand.NAME).execute(controller);
    }

}
