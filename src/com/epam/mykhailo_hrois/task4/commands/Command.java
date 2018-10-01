package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

public abstract class Command {
    public abstract String execute(Controller controller, String[] arguments);
}
