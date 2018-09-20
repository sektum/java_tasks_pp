package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public class SetGoodCommand extends Command {
    public static final String NAME = "SET_GOOD_COMMAND";

    @Override
    public String execute(Controller controller) {
        controller.setSettingGood(true);
        return "Please, enter ID of good you want to work with ->";
    }
}
