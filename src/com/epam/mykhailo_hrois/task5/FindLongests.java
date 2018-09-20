package com.epam.mykhailo_hrois.task5;

public class FindLongests implements Runnable {
    SimpleReadFile reader;

    FindLongests(SimpleReadFile reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            reader.get();
        }
    }
}
