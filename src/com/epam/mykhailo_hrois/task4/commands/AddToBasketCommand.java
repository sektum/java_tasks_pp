package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class AddToBasketCommand extends Command {
    public static final String NAME = "ADD_TO_BASKET_COMMAND";

    @Override
    public String execute(Controller controller, String[] arguments) {
        int id = -1;
        id = Integer.valueOf(arguments[1]);
        if (id == -1) {
            return CommandList.getCommandList().get(SetGoodCommand.NAME).execute(controller, arguments);
        }
        controller.getBasket().add(id - 1);
        return "Good added to basket \n" + CommandList.getCommandList().get(PrintBasketCommand.NAME).execute(controller, arguments);
    }
}
