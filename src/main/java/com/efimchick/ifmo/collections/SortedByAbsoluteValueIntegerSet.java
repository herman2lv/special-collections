package com.efimchick.ifmo.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class SortedByAbsoluteValueIntegerSet implements Set<Integer> {
    private final Set<Integer> set = new TreeSet<>((o1, o2) -> {
        o1 = Math.abs(o1);
        o2 = Math.abs(o2);
        return o1 - o2;
    });

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean add(final Integer integer) {
        return set.add(integer);
    }

    @Override
    public boolean remove(final Object o) {
        return set.remove(o);
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(final Collection<? extends Integer> c) {
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    public void clear() {
        set.clear();
    }
}
