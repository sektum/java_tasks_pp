package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class FiveLastGoodsCommand extends Command {
    public static final String NAME = "FIVE_LAST_GOODS_COMMAND";

    @Override
    public String execute(Controller controller) {
        return controller.getBasket().getFiveLastMap().toString();
    }

}
