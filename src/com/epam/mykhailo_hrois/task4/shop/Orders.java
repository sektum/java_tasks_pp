package com.epam.mykhailo_hrois.task4.shop;

import java.util.Set;
import java.util.TreeMap;

public class Orders {
    private TreeMap<Long, Set<Integer>> ordersMap = new TreeMap<>();

    public TreeMap<Long, Set<Integer>> getOrdersMap() {
        return ordersMap;
    }

    public String printOrders(Long date) {
        StringBuilder sb = new StringBuilder();
        sb.append("Orders: ").append(System.lineSeparator());
        for (Integer goodId : getOrdersMap().get(date)) {
            sb.append(Warehouse.getGoodsList().get(goodId).toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
