package com.epam.mykhailo_hrois.task4.shop;

import com.epam.mykhailo_hrois.task4.entities.Goods;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Goods, Integer> basket;
    private FiveLastMap<Goods, Integer> fiveLastMap;

    public Basket() {
        basket = new HashMap<>();
    }

    public boolean add(Goods good) {
        int count;
        if (good == null) {
            return false;
        }
        if (basket.containsKey(good)) {
            count = basket.get(good) + 1;
            basket.replace(good, count);
        } else {
            basket.put(good, 1);
        }
        return true;
    }

    public boolean delete(Goods good) {
        int count;
        if (good == null || !basket.containsKey(good)) {
            return false;
        } else {
            if (basket.get(good) == 1) {
                basket.remove(good);
            } else {
                count = basket.get(good) - 1;
                basket.replace(good, count);
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return basket.toString();
    }

    public Map<Goods, Integer> getBasket() {
        return basket;
    }

    public FiveLastMap<Goods, Integer> getFiveLastMap() {
        return fiveLastMap;
    }
}
