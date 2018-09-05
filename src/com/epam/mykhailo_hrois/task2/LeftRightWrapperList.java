package com.epam.mykhailo_hrois.task2;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LeftRightWrapperList<E> implements List<E> {
    private List<E> leftList;
    private List<E> rightList;

    private int leftListSize;
    private int rightListSize;
    private int size;

    LeftRightWrapperList(List<E> unmodifiableLeftList, List<E> modifiableRightList) {
        leftList = unmodifiableLeftList;
        rightList = modifiableRightList;
        leftListSize = unmodifiableLeftList.size();
        updateSize();
    }

    private void updateSize() {
        rightListSize = rightList.size();
        size = leftListSize + rightListSize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        rightList.add(o);
        updateSize();
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (rightList.remove(o)) {
            updateSize();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        rightList.addAll(c);
        updateSize();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < leftListSize) {
            throw new UnsupportedOperationException();
        } else {
            rightList.addAll(index - leftListSize, c);
            updateSize();
            return true;
        }
    }

    @Override
    public void clear() {
        rightList.clear();
    }

    @Override
    public E get(int index) {
        E element;
        if (index < leftListSize) {
            element = leftList.get(index);
        } else {
            element = rightList.get(index - leftListSize);
        }
        return element;
    }

    @Override
    public E set(int index, E element) {
        E oldValue;
        if (index < leftListSize) {
            throw new UnsupportedOperationException();
        } else {
            oldValue = rightList.set(index - leftListSize, element);
            return oldValue;
        }
    }

    @Override
    public void add(int index, E element) {
        if (index < leftListSize) {
            throw new UnsupportedOperationException();
        } else {
            rightList.add(index - leftListSize, element);
            updateSize();
        }
    }

    @Override
    public E remove(int index) {
        E oldValue;
        if (index < leftListSize) {
            throw new UnsupportedOperationException();
        } else {
            oldValue = rightList.remove(index - leftListSize);
            updateSize();
            return oldValue;
        }
    }

    @Override
    public int indexOf(Object o) {
        int index;
        index = leftList.indexOf(o);
        if (index == -1) {
            index = rightList.indexOf(o) + leftListSize;
            return index;
        } else {
            return index;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = rightList.lastIndexOf(o) + leftListSize;
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
        boolean flag = rightList.retainAll(c);
        updateSize();
        return flag;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = rightList.removeAll(c);
        updateSize();
        return flag;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean currentFlag;
        for (Object colElement : c) {
            currentFlag = leftList.contains(colElement);
            if (!currentFlag) {
                currentFlag = rightList.contains(colElement);
            }
            if (!currentFlag) {
                return currentFlag;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
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
            //TODO
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            //TODO
            return null;
        }

        @Override
        public void remove() {
            //TODO
        }

    }

}

