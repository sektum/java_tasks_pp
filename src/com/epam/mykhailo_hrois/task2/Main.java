package com.epam.mykhailo_hrois.task2;

import com.epam.mykhailo_hrois.task1.Product;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args){
        ProductList<Product> listOfProducts = new ProductList<>();
        Product pr1 = new Product("iPhone", 9.0, true, false, "Ukraine");
        Product pr2 = new Product("Lenovo", 300., false, false, "US");
        Product pr3 = new Product("HTC", 1.0, true, false, "China");
        listOfProducts.add(new Product());
        Collection collection = new ArrayList();
        collection.add(pr1);
        collection.add(pr2);
        collection.add(pr3);
        listOfProducts.addAll(0, collection);
        System.out.println(listOfProducts.size());
        System.out.println(listOfProducts.toString());
        listOfProducts.add(new Product("Nokia", 8.0, true, false, "UK"));
        System.out.println(listOfProducts.size());
        listOfProducts.remove(1);
        System.out.println(listOfProducts.size());
        System.out.println(listOfProducts.toString());
        System.out.println(listOfProducts.isEmpty());
        listOfProducts.clear();
        System.out.println(listOfProducts.size());
        System.out.println(listOfProducts.isEmpty());
    }
}
