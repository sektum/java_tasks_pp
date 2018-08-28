package com.epam.mykhailo_hrois.task2;

import java.util.*;
import java.util.function.Predicate;

public class ProductList<E> implements List<E> {

    Object[] list = {};
    int length = 0;

    private static final int DEFAULT_CAPACITY = 5;
    private static final Object[] EMPTY_LIST = {};

    @Override
    public boolean add(E e) {
        capacity(length + 1);
        list[length++] = e;
        return true;
    }

    @Override
    public void clear() {
        list = new Object[]{};
        this.length = 0;
    }

    @Override
    public E get(int index) {
        return (E) this.list[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = (E) list[index];
        list[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        capacity(length + 1);
        System.arraycopy(list, index, list, index + 1,
                length - index);
        list[index] = element;
        length++;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) list[index];
        int numMoved = length - index - 1;
        if (numMoved > 0)
            System.arraycopy(list, index + 1, list, index,
                    numMoved);
        list[--length] = null;
        list = Arrays.copyOf(list, this.length);
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < length; i++)
                if (list[i] == null)
                    return i;
        } else {
            for (int i = 0; i < length; i++)
                if (o.equals(list[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = length - 1; i >= 0; i--)
                if (list[i] == null)
                    return i;
        } else {
            for (int i = length - 1; i >= 0; i--)
                if (o.equals(list[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        int counter = 0;
        for (counter = 0; counter < this.length; counter++) {
            if (list[counter] != null) {
                if (list[counter].equals(o))
                    break;
            } else {
                if (list[counter] == o)
                    break;
            }
        }
        if (counter == this.length) {
            return false;
        }
        for (int k = counter; k < this.length - 1; k++)
            list[k] = list[k + 1];
        this.length--;
        list = Arrays.copyOf(list, length);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        capacity(length + numNew);
        System.arraycopy(a, 0, list, length, numNew);
        length += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        capacity(length + numNew);
        int numMoved = length - index;
        if (numMoved > 0)
            System.arraycopy(list, index, list, index + numNew,
                    numMoved);
        System.arraycopy(a, 0, list, index, numNew);
        length += numNew;
        return numNew != 0;
    }


    @Override
    public void sort(Comparator c) {
        Arrays.sort((E[]) list, 0, length, c);
    }

    @Override
    public boolean retainAll(Collection c) {
        final Object[] elementData = this.list;
        int r = 0, w = 0;
        boolean flag = false;
        try {
            for (; r < length; r++)
                if (c.contains(elementData[r]))
                    elementData[w++] = elementData[r];
        } finally {
            if (r != length) {
                System.arraycopy(elementData, r,
                        elementData, w,
                        length - r);
                w += length - r;
            }
            if (w != length) {
                for (int i = w; i < length; i++)
                    elementData[i] = null;
                length = w;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = false;
        if (c.size() == 0)
            return flag;
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            this.remove((E) arr[i]);
            if (arr[i].equals(this.list[i]))
                flag = true;
            else
                flag = false;
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean flag = false;
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            if (!contains(arr[i])) {
                return flag;
            }
        }
        flag = true;
        return flag;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(list, this.length);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == o) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    if (list[i] == o) {
                        return true;
                    }
                } else {
                    if (list[i].equals(o)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void grow(int minCapacity) {
        int oldCapacity = list.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - (Integer.MAX_VALUE - 8) > 0)
            newCapacity = hugeCapacity(minCapacity);
        list = Arrays.copyOf(list, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > (Integer.MAX_VALUE - 8)) ?
                Integer.MAX_VALUE :
                (Integer.MAX_VALUE - 8);
    }

    private void needToGrow(int minCapacity) {
        if (minCapacity - list.length > 0)
            grow(minCapacity);
    }

    private void capacity(int i) {
        needToGrow(calculateCapacity(list, i));
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == EMPTY_LIST) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < list.length; i++) {
            result.append(list[i]);
            result.append(" ");
        }
        result.append("]");
        return result.toString();
    }

    // Iterator
    public Iterator<E> iterator(Predicate<E> predicate) {
        return new IteratorWithCondition<E>(predicate);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorBase<E>();
    }

    class IteratorBase<E> implements Iterator<E> {

        int cursor; // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        IteratorBase() {
        }

        public boolean hasNext() {
            return cursor < length;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= length)
                throw new NoSuchElementException();
            cursor = i + 1;
            return (E) ProductList.this.list[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            ProductList.this.remove(ProductList.this.list[lastRet]);
            cursor = lastRet;
            lastRet = -1;
        }
    }

    class IteratorWithCondition<E> extends IteratorBase<E> {
        Predicate<E> predicate;

        IteratorWithCondition(Predicate<E> predicate) {
            this.predicate = predicate;
        }

        @Override
        public E next(){
            int i = cursor;
            E element = (E) list[i];
            //help
            return element;
        }
    }
}