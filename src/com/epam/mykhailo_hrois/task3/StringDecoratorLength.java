package com.epam.mykhailo_hrois.task3;

public class StringDecoratorLength {
    private final String key;

    StringDecoratorLength(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return this.key.length();
    }
}
