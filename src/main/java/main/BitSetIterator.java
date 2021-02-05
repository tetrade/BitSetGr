package main;

import java.util.Iterator;

public class BitSetIterator<T> implements Iterator<T> {
    private int index;
    private int maxIndex;
    private BitSet<T> bitSet;

    public BitSetIterator(BitSet<T> bitSet) {
        this.index = 0;
        this.maxIndex = bitSet.getCountOfElements();
        this.bitSet = bitSet;
    }


    @Override
    public boolean hasNext() {
        return index < maxIndex;
    }

    @Override
    public T next() {
        T el = bitSet.getElements().get(index);
        index ++;
        return el;
    }
}
