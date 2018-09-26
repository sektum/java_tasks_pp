package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.shop.Warehouse;

public class DisplayGoodsCommand extends Command {
    public static final String NAME = "DISPLAY_GOODS_COMMAND";

    @Override
    public String execute(Controller controller, String[] strings) {
        return Warehouse.getInstance().toString();
    }

}
