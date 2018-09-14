package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class ExceptionCommand extends Command {
    public static final String NAME = "EXCEPTION_COMMAND";

    @Override
    public String execute(Controller controller) {
        controller.setException("There was some problem. Returning to start page");
        return CommandList.getCommandList().get(DisplayGoodsCommand.NAME).execute(controller);
    }
}
