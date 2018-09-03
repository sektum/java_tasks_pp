package com.epam.mykhailo_hrois.task2;

import java.util.*;

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
    public WrapperIterator<E> iterator() {
        return new WrapperIterator<E>();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E o) {
        rightList.add(o);
        updateSize();
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(leftList.contains(o) && !rightList.contains(o)){
            throw new UnsupportedOperationException();
        }
        else {
            rightList.remove(o);
            updateSize();
            return true;
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
        leftList = Collections.EMPTY_LIST;
        rightList = Collections.EMPTY_LIST;
    }

    @Override
    public E get(int index) {
        E element;
        if(index < leftListSize){
            element = leftList.get(index);
        }
        else {
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
        index = leftList.indexOf(o) != -1 ? leftList.indexOf(o) : rightList.indexOf(o);
        return index == -1 ? index : index + leftListSize;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index1, index2;
        index1 = leftList.lastIndexOf(o);
        index2 = rightList.lastIndexOf(o);
        if (index1 == -1) {
            if (index2 == -1) {
                return -1;
            } else {
                return index2 + leftListSize;
            }
        } else {
            if (index2 == -1) {
                return index1;
            } else {
                return index2 + leftListSize;
            }
        }
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
        //TODO
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        //TODO
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        //TODO
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
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

