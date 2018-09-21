package com.epam.mykhailo_hrois.task5;

public class Demo {

    public static void main(String... args) {
        PrintLongests printLongests = new PrintLongests();
        FindAndPush findAndPush = new FindAndPush();
        new Thread(printLongests).start();
        new Thread(findAndPush).start();
    }
}
