package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.controller.Converter;

import java.util.Date;

public class BetweenDatesCommand extends Command {
    public static final String NAME = "BETWEEN_DATES_COMMAND";

    @Override
    public String execute(Controller controller, String[] arguments) {
        Long from = Converter.convertDate(arguments[1]);
        Long to = Converter.convertDate(arguments[2]);
        StringBuilder result = new StringBuilder();
        boolean isInputValid = from < to;

        if (!isInputValid) {
            result.append("First date can't be greater then second");
        }
        for (Long currentDate : controller.getOrders().getOrdersMap().keySet()) {
            if ((currentDate >= from) && (currentDate <= to)) {
                result.append("Order date:" + new Date(currentDate));
                result.append(System.lineSeparator());
                result.append(controller.getOrders().printOrders(currentDate));
            }
        }
        return result.toString();
    }
}
