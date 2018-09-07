package com.epam.mykhailo_hrois.task3;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListSetLol<E> extends ArrayList<E> {
    public ArrayListSetLol() {
        super();
    }

    public ArrayListSetLol(Collection<? extends E> c) {
        addAll(c);
    }

    public ArrayListSetLol(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public boolean add(E e) {
        if (this.contains(e)) {
            return false;
        } else {
            return super.add(e);
        }
    }

    @Override
    public void add(int index, E element) {
        if (!this.contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int oldSize = size();
        for (E e : c) {
            add(e);
        }
        return oldSize != size();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        int oldSize = size();
        Object temp[] = c.toArray();
        for (int i = temp.length - 1; i >= 0; i--) {
            if (!contains(temp[i])) {
                add(index, (E) temp[i]);
            }
        }
        return oldSize != size();
    }
}
