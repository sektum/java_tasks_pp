package com.epam.mykhailo_hrois.task4.shop;

import com.epam.mykhailo_hrois.task4.entities.Goods;
import com.epam.mykhailo_hrois.task4.entities.Keyboard;
import com.epam.mykhailo_hrois.task4.entities.Smartphone;
import com.epam.mykhailo_hrois.task4.entities.Tea;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private static Warehouse instance = new Warehouse();
    private static List<Goods> goodsList = new ArrayList<Goods>();

    static {
        feelWarehouse();
    }

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return Warehouse.instance;
    }

    public static List<Goods> getGoodsList() {
        return goodsList;
    }

    private static void feelWarehouse(){
        int i = 1;
        goodsList.add(new Keyboard(i++, BigDecimal.valueOf(40.99), "hp", "mechanic"));
        goodsList.add(new Keyboard(i++, BigDecimal.valueOf(20.99), "hp", "scissor"));
        goodsList.add(new Smartphone(i++, BigDecimal.valueOf(99.99), "Samsung", "Android 5.0"));
        goodsList.add(new Smartphone(i++, BigDecimal.valueOf(149.99), "Blackview", "Android 7.0"));
        goodsList.add(new Tea(i++, BigDecimal.valueOf(1.), 200.5, "green"));
        goodsList.add(new Tea(i++, BigDecimal.valueOf(1.5), 500.85, "black"));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse\n{");
        for (int i = 0; i < 6; i++) {
            sb.append(goodsList.get(i).toString());
            sb.append(System.lineSeparator());
        }
        sb.append('}');
        return sb.toString();
    }
}
