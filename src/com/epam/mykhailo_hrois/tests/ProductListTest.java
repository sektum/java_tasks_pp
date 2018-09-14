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
    ProductList<Product> collectionIsAvailable;


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
        collectionIsAvailable = new ProductList<>();
        for (Product element : productList) {
            if (element.isAvailable()) {
                collectionIsAvailable.add(element);
            }
        }
    }

    @Test
    public void When_ElementAdded_Expect_True() {
        assertTrue(productList.add(testProduct));
    }

    @Test
    public void When_GettingElementFromList_Expect_EqualToItself() {
        Product forGet = p3;
        assertTrue(productList.get(2).equals(forGet));
    }

    @Test
    public void When_AddingToIndex_Expect_SameElementAfterGettingBy() {
        int expectedIndex = 3;
        productList.add(expectedIndex, testProduct);
        assertTrue(productList.get(expectedIndex).equals(testProduct));
    }

    @Test
    public void When_RemoveElement_Expect_ListMoves() {
        int expectedIndex = 2;
        productList.remove(2);
        assertTrue(productList.get(2).equals(p4));
    }

    @Test
    public void When_RemoveElement_Expect_SizeChanges() {
        int expectedSize = productList.size() - 1;
        productList.remove(1);
        assertTrue(productList.size() == expectedSize);
    }

    @Test
    public void When_CallHasNextOnEmptyList_Expect_False() {
        ProductList<Product> products = new ProductList<>();
        assertFalse(products.iterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void When_CallNextOnEmptyList_Expect_ThrowNoSuchElementException() {
        ProductList<Product> products = new ProductList<>();
        products.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void When_CallNextOnTheLastElement_Expect_ThrowNoSuchElementException() {
        try {
            while (iterator.hasNext()){
                iterator.next();
            }
        }catch (Exception e){}
        iterator.next();
    }

    @Test
    public void When_CallNextOnOneItemSeveralTimes_Expect_True() {
        ProductList<Product> products = new ProductList<>();
        products.add(new Product());
        assertTrue(products.iterator().hasNext());
        assertTrue(products.iterator().hasNext());
        assertTrue(products.iterator().hasNext());
    }

    @Test
    public void When_RemoveAllObjectsThatIteratorWithConditionHasBeenSearched_Expect_FalseOnContainsAllOfThose() {
        while (iteratorWCondition.hasNext()){
            productList.remove(iteratorWCondition.next());
        }
        assertFalse(productList.containsAll(collectionIsAvailable));
    }
}