package com.epam.mykhailo_hrois.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleReadFile {
    private int product=0;
    public synchronized void get() {
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
    public synchronized void put() {
        while (product>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public static byte[] readFile(String pathname) throws IOException {
        return Files.readAllBytes(Paths.get(pathname));
    }
}
