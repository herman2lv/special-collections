package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class PairStringList implements List<String> {
    private final List<String> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    @Override
    public boolean add(final String s) {
        for (int i = 0; i < 2; i++) {
            list.add(s);
        }
        return true;
    }

    @Override
    public void add(int index, final String element) {
        index = correctIndex(index);
        for (int i = 0; i < 2; i++) {
            list.add(index, element);
        }
    }

    private int correctIndex(int index) {
        if (isOdd(index)) {
            return ++index;
        } else return index;
    }

    @Override
    public boolean remove(final Object o) {
        for (int i = 0; i < 2; i++) {
            list.remove(o);
        }
        return true;
    }

    @Override
    public String remove(final int index) {
        list.remove(index);
        return list.remove(getPairIndex(index));
    }

    private int getPairIndex(int index) {
        if (isEven(index)) {
            return ++index;
        } else {
            return --index;
        }
    }

    private boolean isEven(final int number) {
        return (number ^ (number + 1)) == 1;
    }

    private boolean isOdd(final int number) {
        return !isEven(number);
    }

    @Override
    public boolean addAll(final Collection<? extends String> c) {
        for (String string : c) {
            add(string);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, final Collection<? extends String> c) {
        index = correctIndex(index);
        for (String string : c) {
            add(index, string);
            index = index + 2;
        }
        return true;
    }

    @Override
    public String get(final int index) {
        return list.get(index);
    }

    @Override
    public String set(final int index, final String element) {
        list.set(index, element);
        return list.set(getPairIndex(index), element);
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        return list.toArray(a);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return list.contains(o);
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(final Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator(final int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(final int fromIndex, final int toIndex) {
        throw new UnsupportedOperationException();
    }
}
