package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class AddToBasketCommand extends Command {
    public static final String NAME = "ADD_TO_BASKET_COMMAND";

    @Override
    public String execute(Controller controller) {
        if (controller.getEnterId() == -1) {
            return CommandList.getCommandList().get(SetGoodCommand.NAME).execute(controller);
        }
        controller.getBasket().add(controller.getEnterId());
        return "Good added to basket \n" + CommandList.getCommandList().get(PrintBasketCommand.NAME).execute(controller);
    }
}
