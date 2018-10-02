package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.shop.Warehouse;

public class DisplayGoodsCommand extends Command {
    public static final String NAME = "Display goods from the Shop";

    @Override
    public String execute(Controller controller, String[] arguments) {
        return Warehouse.getInstance().toString();
    }

}
