package com.epam.mykhailo_hrois.task3;

public class StringDecoratorSymbols {
    private final String key;

    StringDecoratorSymbols(String key){
        this.key = key;
    }

    @Override
    public int hashCode() {
        char[] arr = key.toCharArray();
        int hash = 0;
        for (int i = 0; i < 4; i++) {
            hash+=arr[i];
        }
        return hash;
    }
}
