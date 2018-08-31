package com.epam.mykhailo_hrois.task2;

import com.epam.mykhailo_hrois.task1.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        ProductList<Product> listOfProducts = new ProductList<>();
        Product pr1 = new Product("iPhone", 9.0, true, false, "Ukraine");
        Product pr2 = new Product("Lenovo", 300., false, false, "US");
        Product pr3 = new Product("HTC", 1.0, true, false, "China");
        listOfProducts.add(new Product("", 0., true, false, "Uk"));
        Collection collection = new ArrayList();
        collection.add(pr1);
        collection.add(pr2);
        collection.add(pr3);
        listOfProducts.addAll(1, collection);
        listOfProducts.add(null);
        listOfProducts.add(new Product());
        listOfProducts.add(new Product());
        listOfProducts.add(null);
        listOfProducts.add(new Product());
        listOfProducts.add(pr1);
        listOfProducts.add(pr1);
        listOfProducts.add(pr1);
        System.out.println(listOfProducts);
        System.out.println(listOfProducts.size());
        Predicate<Product> predicate = Product::isAvailable;
        Iterator<Product> iterator = listOfProducts.iterator(predicate);
        Iterator<Product> iterator2 = listOfProducts.iterator(predicate.negate());
        int count = 0;
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
