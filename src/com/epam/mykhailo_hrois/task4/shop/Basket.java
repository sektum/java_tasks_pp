package com.epam.mykhailo_hrois.task4.shop;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private static FiveLastMap<Integer, Integer> fiveLastMap = new FiveLastMap(true);
    private Map<Integer, Integer> basket = new HashMap<>();

    public Basket() {
    }

    public boolean add(Integer goodId) {
        int count;
        if (goodId == null) {
            return false;
        }
        if (basket.containsKey(goodId)) {
            count = basket.get(goodId) + 1;
            basket.replace(goodId, count);
        } else {
            basket.put(goodId, 1);
        }
        fiveLastMap.put(goodId, 1);
        return true;
    }

    public boolean delete(Integer goodId) {
        int count;
        if (goodId == null || !basket.containsKey(goodId)) {
            return false;
        } else {
            if (basket.get(goodId) == 1) {
                basket.remove(goodId);
            } else {
                count = basket.get(goodId) - 1;
                basket.replace(goodId, count);
            }
        }
        fiveLastMap.remove(goodId);
        return true;
    }

    public void deleteAll() {
        basket.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Basket: ").append(System.lineSeparator());
        for (Integer goodID : this.basket.keySet()) {
            sb.append(Warehouse.getGoodsList().get(goodID).toString());
            sb.append(" , count = ");
            sb.append(basket.get(goodID));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public Map<Integer, Integer> getBasketMap() {
        return basket;
    }

    public FiveLastMap<Integer, Integer> getFiveLastMap() {
        return fiveLastMap;
    }

    public String printFiveLast() {
        StringBuilder sb = new StringBuilder();
        sb.append("Five last: ").append(System.lineSeparator());
        for (Object goodId : fiveLastMap.keySet()) {
            int i = (int) goodId;
            sb.append(Warehouse.getGoodsList().get(i).toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
