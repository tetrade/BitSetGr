package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitSet<T> {
    private int currentCountOfElements;
    private int countOfElements;
    private ArrayList<T> elements;

    public BitSet(int countOfElements) {
        currentCountOfElements = 0;
        elements =  new ArrayList<T>();
        this.countOfElements = countOfElements;
    }

    public BitSet(ArrayList<T> arrayList) {
        elements =  arrayList;
        currentCountOfElements = arrayList.size();
        countOfElements = arrayList.size();
    }


    public void add(T element){
        if (currentCountOfElements + 1 > countOfElements) {
            throw new IllegalArgumentException("Index out of range");
        }
        else if (!elements.contains(element)) {
            elements.add(element);
            currentCountOfElements += 1;
        }
    }

    public void addAll(T[] elements){
        for (T element: elements) {
            this.add(element);
        }
    }

    public void addAll(List<T> elements){
        for (T element: elements) {
            this.add(element);
        }
    }

    public BitSet<T> intersectionWith(BitSet<T> bitSet) {
        ArrayList<T> newBit = new ArrayList();
        for (T el: elements) {
            if (bitSet.elements.contains(el)) {
                newBit.add(el);
            }
        }
        return new BitSet<T>(newBit);
    }
    public BitSet<T> unificationWith(BitSet<T> bitSet){
        BitSet<T> newBit = new BitSet<T>(currentCountOfElements + bitSet.currentCountOfElements);
        newBit.addAll(elements);
        newBit.addAll(bitSet.elements);
        return newBit;
    }
    public int indexOf(T element){
        return elements.indexOf(element);
    }

    public boolean contains(T element){
        return elements.contains(element);
    }

    public void remove(T element) {
        elements.remove(element);
        currentCountOfElements = Integer.max(0, this.currentCountOfElements - 1);
    }

    public void removeAll(T[] elements) {
        this.elements.removeAll(Arrays.asList(elements));
        currentCountOfElements = Integer.max(0, this.currentCountOfElements - elements.length);
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    public ArrayList<T> getElements() {
        return elements;
    }
}
