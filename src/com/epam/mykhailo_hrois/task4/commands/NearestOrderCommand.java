package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.controller.Converter;

import java.util.Date;

public class NearestOrderCommand extends Command {
    public static final String NAME = "\"Nearest order by a date. Format: \"7 yyyy-mm-dd;HH:mm:ss\"";

    @Override
    public String execute(Controller controller, String[] arguments) {
        StringBuilder result = new StringBuilder();
        long time = Converter.convertDate(arguments[1]);
        long minDiff = Long.MAX_VALUE;
        Long foundedOrderKeyTime = null;

        for (Long orderTime : controller.getOrders().getOrdersMap().keySet()) {
            if (Math.abs(time - orderTime) < minDiff) {
                foundedOrderKeyTime = orderTime;
                minDiff = Math.abs(time - orderTime);
            }
        }
        if (foundedOrderKeyTime != null) {
            result.append(new Date(foundedOrderKeyTime));
            result.append(System.lineSeparator());
            result.append(controller.getOrders().printOrders(foundedOrderKeyTime));
        } else {
            result.append("Orders list is empty");
        }
        return result.toString();
    }
}
