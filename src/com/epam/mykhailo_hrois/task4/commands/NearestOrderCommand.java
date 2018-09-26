package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;

import java.util.Date;

public class NearestOrderCommand extends Command {
    public static final String NAME = "NEAREST_ORDER_COMMAND";

    @Override
    public String execute(Controller controller, String[] strings) {
        controller.setEnteredDate(strings[1]);
        StringBuilder result = new StringBuilder();
        long time = controller.getEnteredDate();
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
        controller.setEnteredDate(null);
        return result.toString();
    }
}
