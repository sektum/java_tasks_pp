package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.shop.Warehouse;

import java.util.Date;
import java.util.HashSet;

public class OrderGoodsCommand extends Command {
    public static final String NAME = "ORDER_GOODS_COMMAND";

    @Override
    public String execute(Controller controller) {
        controller.setEnteredDate(controller.getValue());
        controller.setOrdering(false);
        controller.getOrders().getOrdersMap().put(controller.getEnteredDate(), new HashSet<>(controller.getBasket().getBasketMap().keySet()));
        StringBuilder result = new StringBuilder();
        result.append("Order added for goods: ");
        result.append(System.lineSeparator());
        for (Integer goodID : controller.getOrders().getOrdersMap().get(controller.getEnteredDate())) {
            result.append(Warehouse.getGoodsList().get(goodID).toString());
            result.append(System.lineSeparator());
        }
        result.append("Date: ");
        result.append(new Date(controller.getEnteredDate()));
        result.append(System.lineSeparator());
        controller.getBasket().deleteAll();
        controller.setEnteredDate(null);
        return result.toString();
    }
}
