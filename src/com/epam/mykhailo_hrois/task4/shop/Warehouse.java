package com.epam.mykhailo_hrois.task4.shop;

public class Warehouse {
    private static Warehouse instance = new Warehouse();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return Warehouse.instance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append('}');
        return sb.toString();
    }
}
