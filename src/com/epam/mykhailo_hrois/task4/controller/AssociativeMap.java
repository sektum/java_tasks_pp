package com.epam.mykhailo_hrois.task4.controller;

import com.epam.mykhailo_hrois.task4.commands.*;

import java.util.HashMap;
import java.util.Map;

public class AssociativeMap {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("1", DisplayGoodsCommand.NAME);
        map.put("2", PrintBasketCommand.NAME);
        map.put("3", AddToBasketCommand.NAME);
        map.put("4", FiveLastGoodsCommand.NAME);
        map.put("5", BuyAllFromBasketCommand.NAME);
        map.put("6", OrderOnDateCommand.NAME);
        map.put("7", NearestOrderCommand.NAME);
        map.put("8", BetweenDatesCommand.NAME);
        map.put("help", PrintCommand.NAME);
        map.put("start", StartCommand.NAME);
        map.put("exit", ExitCommand.NAME);
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String print() {
        final StringBuilder sb = new StringBuilder("Commands: ");
        sb.append(System.lineSeparator());
        for (int i = 1; i <= 8; i++) {
            sb.append(String.valueOf(i));
            sb.append(" - ");
            sb.append(map.get(String.valueOf(i)));
            sb.append(System.lineSeparator());
        }
        sb.append("help").append(" - ").append(PrintCommand.NAME).append(System.lineSeparator());
        sb.append("type \"exit\" to quit").append(System.lineSeparator());
        return sb.toString();
    }
}
