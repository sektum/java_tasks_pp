package com.epam.mykhailo_hrois.task2;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.function.UnaryOperator;

public class ProductList<E> implements List<E> {

    Object[] list;
    int length = 0;

    @Override
    public boolean add(E e) {
        if (this.length != 0) {
            list = Arrays.copyOf(list, ++this.length);
            list[this.length - 1] = e;
            return true;
        }
        if (this.length == 0) {
            list = new Object[]{e};
            this.length++;
            return true;
        }
        return false;
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
        Object[] leftList = Arrays.copyOfRange(list, 0, index);
        leftList = Arrays.copyOf(leftList, leftList.length + 1);
        leftList[index] = element;
        Object[] rightList = Arrays.copyOfRange(list, index, length);
        list = new Object[leftList.length + rightList.length];
        System.arraycopy(leftList, 0, list, 0, leftList.length);
        System.arraycopy(rightList, 0, list, leftList.length, rightList.length);
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
        boolean flag = false;
        if (c.size() == 0)
            return flag;
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            this.add((E) arr[i]);
            if (arr[i].equals(this.list[i]))
                flag = true;
            else
                flag = false;
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        list = list = Arrays.copyOf(list, this.length + c.size());
        Object[] a = c.toArray();
        int numNew = a.length;

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
        boolean modified = false;
        try {
            for (; r < length; r++)
                if (c.contains(elementData[r]))
                    elementData[w++] = elementData[r];
        } finally {
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            if (r != length) {
                System.arraycopy(elementData, r,
                        elementData, w,
                        length - r);
                w += length - r;
            }
            if (w != length) {
                // clear to let GC do its work
                for (int i = w; i < length; i++)
                    elementData[i] = null;
                length = w;
                modified = true;
            }
        }
        return modified;
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
    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl<E>();
    }

    private class IteratorImpl<E> implements Iterator<E> {

        int cursor; // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        IteratorImpl() {
            // TODO Auto-generated constructor stub
        }

        public boolean hasNext() {
            return cursor != length;
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
}