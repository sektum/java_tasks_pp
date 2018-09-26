package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

import java.util.Date;

public class BetweenDatesCommand extends Command {
    public static final String NAME = "BETWEEN_DATES_COMMAND";

    @Override
    public String execute(Controller controller, String[] strings) {
        controller.setEnteredDate(strings[1]);
        controller.setEnteredSecondDate(strings[2]);
        StringBuilder result = new StringBuilder();
        long from = controller.getEnteredDate();
        long to = controller.getEnteredSecondDate();
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
