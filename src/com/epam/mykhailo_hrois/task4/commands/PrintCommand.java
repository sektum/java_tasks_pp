package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.AssociativeMap;
import com.epam.mykhailo_hrois.task4.controller.Controller;

public class PrintCommand extends Command {
    public static final String NAME = "PRINT_COMMANDS";

    @Override
    public String execute(Controller controller) {
        return AssociativeMap.print();
    }
}
