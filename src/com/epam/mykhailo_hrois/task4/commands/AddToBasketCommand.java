package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class AddToBasketCommand extends Command {
    public static final String NAME = "Add good to basket. Format: \"3 id\" ";

    @Override
    public String execute(Controller controller, String[] arguments) {
        int id = -1;
        try {
            id = Integer.valueOf(arguments[1]);
        } catch (NumberFormatException e){
            return "Wrong data. Please enter ID correctly";
        }
        controller.getBasket().add(id - 1);
        return "Good added to basket \n" + CommandList.getCommandList().get(PrintBasketCommand.NAME).execute(controller, arguments);
    }
}
