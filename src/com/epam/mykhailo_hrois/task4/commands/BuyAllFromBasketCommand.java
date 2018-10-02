package com.epam.mykhailo_hrois.task4.commands;

import com.epam.mykhailo_hrois.task4.controller.Controller;
import com.epam.mykhailo_hrois.task4.entities.Goods;
import com.epam.mykhailo_hrois.task4.shop.Warehouse;

import java.math.BigDecimal;
import java.util.Map;

public class BuyAllFromBasketCommand extends Command {
    public static final String NAME = "Buy all from basket. Clears basket as well";

    @Override
    public String execute(Controller controller, String[] arguments) {
        BigDecimal price = BigDecimal.ZERO;
        Map<Integer, Integer> basket = controller.getBasket().getBasketMap();
        Goods good;
        for (Integer goodId : basket.keySet()) {
            good = Warehouse.getGoodsList().get(goodId);
            price = price.add(good.getPrice().multiply(new BigDecimal(basket.get(goodId))));
        }
        controller.getBasket().deleteAll();
        return String.valueOf(price);
    }
}
