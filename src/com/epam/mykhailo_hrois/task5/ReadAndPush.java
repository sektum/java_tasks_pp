package com.epam.mykhailo_hrois.task5;

public class ReadAndPush implements Runnable{
    SimpleReadFile reader;
    ReadAndPush(SimpleReadFile reader){
        this.reader = reader;
    }
    @Override
    public void run(){
        for (int i = 1; i < 6; i++) {
            reader.put();
        }
    }
}
