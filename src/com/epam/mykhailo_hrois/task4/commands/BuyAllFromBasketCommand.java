package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.entities.Goods;

import java.math.BigDecimal;
import java.util.Map;

public class BuyAllFromBasketCommand extends Command {
    public static final String NAME = "BUY_ALL_COMMAND";

    @Override
    public String execute(Controller controller) {
        BigDecimal price = BigDecimal.ZERO;
        Map<Goods, Integer> basket = controller.getBasket().getBasketMap();
        for (Goods good : basket.keySet()) {
            price = price.add(good.getPrice().multiply(new BigDecimal(basket.get(good))));
        }
        return String.valueOf(price);
    }
}
