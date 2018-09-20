package com.epam.mykhailo_hrois.task4.shop;

import java.util.LinkedHashMap;
import java.util.Map;

public class FiveLastMap<P, V> extends LinkedHashMap {
    static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    public FiveLastMap(boolean accessOrder) {
        super(INITIAL_CAPACITY, LOAD_FACTOR, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > 5;
    }

}
