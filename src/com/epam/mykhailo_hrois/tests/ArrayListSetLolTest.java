package com.epam.mykhailo_hrois.tests;

import com.epam.mykhailo_hrois.task3.ArrayListSetLol;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

public class ArrayListSetLolTest {
    private ArrayListSetLol<String> listSetLol;
    private Collection<String> collection;

    @Before
    public void setUp() {
        listSetLol = new ArrayListSetLol<>();
        collection = new ArrayList<>();
        listSetLol.add("one");
        listSetLol.add("two");
        collection.add("first");
        collection.add("two");
    }

    @Test
    public void add() {
        final int EXPECTED_SIZE = 3;
        listSetLol.add("some");
        listSetLol.add("some");
        assertEquals(EXPECTED_SIZE, listSetLol.size());
    }

    @Test
    public void add_Index() {
        final int EXPECTED_SIZE = 2;
        listSetLol.add(1, "two");
        assertEquals(EXPECTED_SIZE, listSetLol.size());
    }

    @Test
    public void addAll() {
        final int EXPECTED_SIZE = 3;
        listSetLol.addAll(collection);
        assertEquals(EXPECTED_SIZE, listSetLol.size());
    }

    @Test
    public void addAll_Index() {
        final int EXPECTED_SIZE = 3;
        listSetLol.addAll(1, collection);
        listSetLol.addAll(0, collection);
        assertEquals(EXPECTED_SIZE, listSetLol.size());
    }
}