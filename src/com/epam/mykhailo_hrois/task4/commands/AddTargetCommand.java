package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.shop.Warehouse;

public class AddTargetCommand extends Command {
    public static final String NAME = "ADD_TARGET_COMMAND";

    @Override
    public String execute(Controller controller) {
        controller.setEnterId(Integer.valueOf(controller.getValue()) - 1);
        controller.setSettingGood(false);
        return "You are on Good: " + Warehouse.getGoodsList().get(controller.getEnterId()).toString();
    }
}
