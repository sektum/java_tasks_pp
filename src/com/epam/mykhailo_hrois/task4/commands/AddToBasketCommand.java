package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class AddToBasketCommand extends Command {
    public static final String NAME = "ADD_TO_BASKET_COMMAND";

    @Override
    public String execute(Controller controller) {
        basket.add(controller.getGood());
        return CommandList.getCommandList().get(PrintBasketCommand.NAME).execute(controller);
    }
}
