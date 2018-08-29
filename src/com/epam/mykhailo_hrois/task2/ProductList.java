package com.epam.mykhailo_hrois.task2;

import java.util.*;
import java.util.function.Predicate;

public class ProductList<E> implements List<E> {

    Object[] array = {};
    int size = 0;

    private static final int DEFAULT_CAPACITY = 5;
    private static final Object[] EMPTY_LIST = {};

    @Override
    public boolean add(E e) {
        capacity(size + 1);
        array[size++] = e;
        return true;
    }

    @Override
    public void clear() {
        array = new Object[]{};
        this.size = 0;
    }

    @Override
    public E get(int index) {
        return (E) this.array[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = (E) array[index];
        array[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        capacity(size + 1);
        System.arraycopy(array, index, array, index + 1,
                size - index);
        array[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index,
                    numMoved);
        }
        array[--size] = null;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
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
        int counter;
        counter = indexOf(o);

        if (counter == -1) {
            return false;
        } else {
            remove(indexOf(o));
            return true;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        capacity(size + numNew);
        System.arraycopy(a, 0, array, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        capacity(size + numNew);
        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(array, index, array, index + numNew,
                    numMoved);
        }
        System.arraycopy(a, 0, array, index, numNew);
        size += numNew;
        return numNew != 0;
    }


    @Override
    public void sort(Comparator c) {
        Arrays.sort((E[]) array, 0, size, c);
    }

    @Override
    public boolean retainAll(Collection c) {
        final Object[] elementData = this.array;
        int r = 0, w = 0;
        boolean flag = false;
        try {
            for (; r < size; r++) {
                if (c.contains(elementData[r])) {
                    elementData[w++] = elementData[r];
                }
            }
        } finally {
            if (r != size) {
                System.arraycopy(elementData, r,
                        elementData, w,
                        size - r);
                w += size - r;
            }
            if (w != size) {
                for (int i = w; i < size; i++) {
                    elementData[i] = null;
                }
                size = w;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = false;
        if (c.isEmpty()) {
            return flag;
        }
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            this.remove((E) arr[i]);
            if (arr[i].equals(this.array[i])) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            if (!contains(arr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, this.size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == o) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    if (array[i] == o) {
                        return true;
                    }
                } else {
                    if (array[i].equals(o)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - (Integer.MAX_VALUE - 8) > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        array = Arrays.copyOf(array, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > (Integer.MAX_VALUE - 8)) ?
                Integer.MAX_VALUE :
                (Integer.MAX_VALUE - 8);
    }

    private void needToGrow(int minCapacity) {
        if (minCapacity - array.length > 0) {
            grow(minCapacity);
        }
    }

    private void capacity(int i) {
        needToGrow(calculateCapacity(array, i));
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
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
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

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            lastRet = i;
            return (E) ProductList.this.array[i];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            ProductList.this.remove(ProductList.this.array[lastRet]);
            cursor = lastRet;
            lastRet = -1;
        }
    }

    class IteratorWithCondition<E> extends IteratorBase<E> {
        Predicate<E> predicate;

        IteratorWithCondition(Predicate<E> predicate) {
            this.predicate = predicate;
            cursor = findNext(cursor);
        }

        @Override
        public E next() {
            E element = (E) array[cursor];
            lastRet = cursor;
            cursor = findNext(++cursor);
            return element;
        }

        private int findNext(int cursor) {
            for (; cursor < size; cursor++) {
                if (array[cursor] != null && predicate.test((E) array[cursor])) {
                    return cursor;
                }
            }
            return size;
        }
    }
}
