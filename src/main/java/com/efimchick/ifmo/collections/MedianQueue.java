package com.efimchick.ifmo.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class MedianQueue implements Queue<Integer> {
    private final LinkedList<Integer> queue = new LinkedList<>();

    @Override
    public boolean offer(final Integer integer) {
        queue.offer(integer);
        rearrangeQueue();
        return true;
    }

    private void rearrangeQueue() {
        LinkedList<Integer> sortedList = new LinkedList<>(queue);
        Collections.sort(sortedList);
        clear();
        int initialSize = sortedList.size();
        for (int i = 0; i < initialSize; i++) {
            if (isEven(i)) {
                queue.addFirst(sortedList.pollLast());
            } else {
                queue.addFirst(sortedList.pollFirst());
            }
        }
    }

    private boolean isEven(final int number) {
        return (number ^ (number + 1)) == 1;
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return queue.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        return queue.toArray(a);
    }

    @Override
    public boolean add(final Integer integer) {
        return queue.add(integer);
    }

    @Override
    public boolean remove(final Object o) {
        if (queue.remove(o)) {
            rearrangeQueue();
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean addAll(final Collection<? extends Integer> c) {
        queue.addAll(c);
        rearrangeQueue();
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        if (queue.removeAll(c)) {
            rearrangeQueue();
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return queue.retainAll(c);
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public Integer remove() {
        Integer removed = queue.remove();
        rearrangeQueue();
        return removed;
    }

    @Override
    public Integer poll() {
        Integer removed = queue.poll();
        rearrangeQueue();
        return removed;
    }

    @Override
    public Integer element() {
        return queue.element();
    }

    @Override
    public Integer peek() {
        return queue.peek();
    }
}
