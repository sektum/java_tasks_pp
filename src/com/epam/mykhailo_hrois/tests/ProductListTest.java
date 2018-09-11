package com.epam.mykhailo_hrois.tests;

import com.epam.mykhailo_hrois.task1.Product;
import com.epam.mykhailo_hrois.task2.ProductList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductListTest {
    ProductList<Product> productList;
    Iterator<Product> iterator;
    Iterator<Product> iteratorWCondition;
    Product p1 = new Product("product1", 300., true, false, "Ukraine");
    Product p2 = new Product("product2", 100., false, false, "Ukraine");
    Product p3 = new Product("product3", 49.99, true, false, "Ukraine");
    Product p4 = new Product("product4", 79.99, false, false, "Ukraine");
    Product p5 = new Product("product5", 999.99, true, false, "Ukraine");
    Product testProduct = new Product("testProduct", 0., true, true, "China");
    Collection<Product> collectionIsAvailable;


    @Before
    public void setUp() throws Exception {
        productList = new ProductList<>();
        iterator = productList.iterator();
        iteratorWCondition = productList.iterator(Product::isAvailable);
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        collectionIsAvailable = new ArrayList<>();
        for (Product element : productList) {
            if (element.isAvailable()) {
                collectionIsAvailable.add(element);
            }
        }
    }

    @Test
    public void isAddReturnsTrue() {
        assertTrue(productList.add(testProduct));
    }

    @Test
    public void isGetReturnsCurrentObject() {
        Product forGet = p3;
        assertTrue(productList.get(2).equals(forGet));
    }

    @Test
    public void isIndexAfterAddingCorrect() {
        int expectedIndex = 3;
        productList.add(expectedIndex, testProduct);
        assertTrue(productList.get(expectedIndex).equals(testProduct));
    }

    @Test
    public void isRemoveMovesList() {
        int expectedIndex = 2;
        productList.remove(2);
        assertTrue(productList.get(2).equals(p4));
    }

    @Test
    public void isRemoveChangesSize() {
        int expectedSize = productList.size() - 1;
        productList.remove(1);
        assertTrue(productList.size() == expectedSize);
    }

    @Test
    public void hasNextOnEmpty() {
        ProductList<Product> products = new ProductList<>();
        assertFalse(products.iterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextOnEmpty() {
        ProductList<Product> products = new ProductList<>();
        products.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void nextOnTheLast() {
        try {
            while (iterator.hasNext()){
                iterator.next();
            }
        }catch (Exception e){}
        iterator.next();
    }

    @Test
    public void hasNextOnOneItemSeveralTimes() {
        ProductList<Product> products = new ProductList<>();
        products.add(new Product());
        assertTrue(products.iterator().hasNext());
        assertTrue(products.iterator().hasNext());
        assertTrue(products.iterator().hasNext());
    }

    @Test
    public void isIteratorWithConditionGetsRightObjects() {
        while (iteratorWCondition.hasNext()){
            productList.remove(iteratorWCondition.next());
        }
        assertFalse(productList.containsAll(collectionIsAvailable));
    }
}