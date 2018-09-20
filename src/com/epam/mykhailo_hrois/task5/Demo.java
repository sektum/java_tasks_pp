package com.epam.mykhailo_hrois.task5;

import java.io.IOException;

public class Demo {

    public static void main(String... args) throws IOException {
        FindLongests findLongests = new FindLongests();
        new Thread(findLongests).start();
    }
}
