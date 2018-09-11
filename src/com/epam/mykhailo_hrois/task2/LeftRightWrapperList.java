package com.epam.mykhailo_hrois.task2;

import java.lang.reflect.Array;
import java.util.*;

public class LeftRightWrapperList<E> implements List<E> {
    private List<E> leftList;
    private List<E> rightList;

    LeftRightWrapperList(List<E> unmodifiableLeftList, List<E> modifiableRightList) {
        leftList = unmodifiableLeftList;
        rightList = modifiableRightList;
    }

    @Override
    public int size() {
        return leftList.size() + rightList.size();
    }

    @Override
    public boolean isEmpty() {
        return leftList.isEmpty() && rightList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return leftList.contains(o) || rightList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new WrapperIterator<E>();
    }

    @Override
    public E[] toArray() {
        E[] leftArray = (E[]) leftList.toArray();
        E[] rightArray = (E[]) rightList.toArray();
        int leftLen = leftArray.length;
        int rightLen = rightArray.length;
        E[] newArray = (E[]) Array.newInstance(leftArray.getClass().getComponentType(), leftLen + rightLen);
        System.arraycopy(leftArray, 0, newArray, 0, leftLen);
        System.arraycopy(rightArray, 0, newArray, leftLen, rightLen);
        return newArray;
    }

    @Override
    public boolean add(E o) {
        return rightList.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return rightList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < leftList.size()) {
            throw new UnsupportedOperationException();
        } else {
            rightList.addAll(index - leftList.size(), c);
            return true;
        }
    }

    @Override
    public void clear() {
        if (leftList.isEmpty()) {
            rightList.clear();
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public E get(int index) {
        E element;
        if (index < leftList.size()) {
            element = leftList.get(index);
        } else {
            element = rightList.get(index - leftList.size());
        }
        return element;
    }

    @Override
    public E set(int index, E element) {
        E oldValue;
        if (index < leftList.size()) {
            if (leftList.get(index).equals(element)) {
                oldValue = leftList.set(index, element);
                return oldValue;
            } else {
                throw new UnsupportedOperationException();
            }
        } else {
            oldValue = rightList.set(index - leftList.size(), element);
            return oldValue;
        }
    }


    @Override
    public void add(int index, E element) {
        if (index < leftList.size()) {
            throw new UnsupportedOperationException();
        } else {
            rightList.add(index - leftList.size(), element);
        }
    }

    @Override
    public E remove(int index) {
        E oldValue;
        if (index < leftList.size()) {
            throw new UnsupportedOperationException();
        } else {
            oldValue = rightList.remove(index - leftList.size());
            return oldValue;
        }
    }

    @Override
    public int indexOf(Object o) {
        int index;
        index = leftList.indexOf(o);
        if (index == -1) {
            index = rightList.indexOf(o) + leftList.size();
            return index;
        } else {
            return index;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = rightList.lastIndexOf(o) + leftList.size();
        if (lastIndex == -1) {
            lastIndex = leftList.lastIndexOf(o);
        }
        return lastIndex;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        return rightList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return rightList.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object colElement : c) {
            if (!this.contains(colElement)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < size()) {
            return toArray();
        } else {
            System.arraycopy(toArray(), 0, a, 0, size());
            if (a.length > size()) {
                a[size()] = null;
            }
            return a;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LeftRightWrapperList{");
        sb.append("leftList=").append(leftList);
        sb.append(", rightList=").append(rightList);
        sb.append('}');
        return sb.toString();
    }

    class WrapperIterator<E> implements Iterator<E> {

        int cursor;

        WrapperIterator() {
        }

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            if (toRightCheck()) {
                return (E) leftList.get(i);
            } else {
                return (E) rightList.get(i - leftList.size());
            }
        }

        private boolean toRightCheck() {
            return (cursor - 1) < leftList.size();
        }
    }

}

