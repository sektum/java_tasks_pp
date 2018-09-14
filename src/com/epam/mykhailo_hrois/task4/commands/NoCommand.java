package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class NoCommand extends Command {
    public static final String NAME = "NO_COMMAND";

    @Override
    public String execute(Controller controller) {
        controller.setException("There is no such command");
        return CommandList.getCommandList().get(DisplayGoodsCommand.NAME).execute(controller);
    }

}
