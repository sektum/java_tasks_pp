package com.epam.mykhailo_hrois.task4.basket;

import com.epam.mykhailo_hrois.task4.entities.Goods;

import java.util.Hashtable;

public class Basket {
    private Hashtable<Goods, Integer> basket;

    Basket() {
        basket = new Hashtable<>();
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
}
