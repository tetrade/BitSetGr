package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitSet<T> {
    private int currentCountOfElements;
    private int countOfElements;
    private ArrayList<T> elements;

    public BitSet(int countOfElements) {
        this.currentCountOfElements = 0;
        this.countOfElements = countOfElements;
        this.elements = new ArrayList<>(countOfElements);
    }


    public void add(T element){
        if (!this.elements.contains(element) && this.currentCountOfElements  < this.countOfElements) {
            this.elements.add(element);
            this.currentCountOfElements += 1;
        }
    }
// Элементы которые не помещаются, просто не будут добавлены
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

    public void intersectionWith(BitSet<T> bitSet) {
        List<T> toDel = new ArrayList();
        for (T el: this.elements) {
            if (!bitSet.elements.contains(el)) {
                toDel.add(el);
            }
        }
        this.removeAll((T[]) toDel.toArray());
    }
    public void unificationWith(BitSet<T> bitSet){
        this.addAll(bitSet.elements);
    }
    public int indexOf(T element){
        return this.elements.indexOf(element);
    }

    public boolean contains(T element){
        return this.elements.contains(element);
    }

    public void remove(T element) {
        this.elements.remove(element);
        this.currentCountOfElements = Integer.max(0, this.currentCountOfElements - 1);
    }

    public void removeAll(T[] elements) {
        this.elements.removeAll(Arrays.asList(elements));
        this.currentCountOfElements = Integer.max(0, this.currentCountOfElements - elements.length);
    }

    @Override
    public String toString() {
        return this.elements.toString();
    }

    public ArrayList<T> getElements() {
        return elements;
    }
}
