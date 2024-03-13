package punto11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * Definition of the Simple List class with Generics
 * @param <T>
 *
 * **/

public class Polinomio<T extends Number> implements Iterable<T[]> {

    private Termino<T> firstTermino;
    private Termino<T> lastTermino;
    private int size;


    public Polinomio() {
        firstTermino = null;
        lastTermino = null;
        size = 0;
    }


    //Basic methods


    //Add to the beginning of the list
    public void addFirst(T c,T e) {
        Termino<T> newTermino = new Termino<>(c,e);
        if(isEmpty()) {
            firstTermino = newTermino;
            lastTermino = newTermino;
        }
        else {
            newTermino.setNextTermino(firstTermino);
            firstTermino = newTermino;
        }
        size++;
    }


    /**
     * Add to the end of the list
     * @param nodeValue
     */
    public void add(T[] value) {
        Termino<T> newTermino = new Termino<>(value);

        if(isEmpty()) {
            firstTermino = lastTermino = newTermino;
        } else {
            lastTermino.setNextTermino(newTermino);
            lastTermino = newTermino;
        }
        size++;
    }


    //Get the value of a Termino
    public T[] getValue(int index) {
        Termino<T> tempTermino = null;
        int counter = 0;
        if(validIndex(index)){
            tempTermino = firstTermino;
            while (counter < index) {
                tempTermino = tempTermino.getNextTermino();
                counter++;
            }
        }
        if(tempTermino != null)
            return tempTermino.getTerminoValue();
        else
            return null;
    }


    //Check if index is valid
    private boolean validIndex(int index) {
        if( index >= 0 && index < size ) {
            return true;
        }
        throw new IndexOutOfBoundsException("Invalid Index");
    }


    //Check if the list is empty
    public boolean isEmpty() {
        return(firstTermino == null) ? true : false;
    }


    /**
     * Print the linked list to the console
     */
    public void printList() {

        Termino<T> aux = firstTermino;

        while(aux != null) {
            System.out.print( aux.toString() + "\t" );
            aux = aux.getNextTermino();
        }

        System.out.println();
    }

    //Delete a Termino by its value
    public T[] remove(T[] data){
        Termino<T> termino = firstTermino;
        Termino<T> previous = null;
        Termino<T> next = null;
        boolean found = false;

        //find previous Termino
        while(termino != null) {
            if( termino.getTerminoValue() == data ) {
                found = true;
                break;
            }
            previous = termino;
            termino = termino.getNextTermino();
        }

        if(found) {
            next = termino.getNextTermino();
            if( previous == null ) {
                firstTermino = next;
            } else {
                previous.setNextTermino(next);
            }

            if(next == null) {
                lastTermino = previous;
            } else {
                termino.setNextTermino(null);
            }

            termino = null;
            size--;
            return data;
        }
        throw new RuntimeException("Element does not exist");
    }


    //Delete the first Termino of the list
    public T[] removeFirst() {

        if( !isEmpty() ) {
            Termino<T> n = firstTermino;
            T[] value = n.getTerminoValue();
            firstTermino = n.getNextTermino();

            if(firstTermino == null) {
//              lastTermino = null;
            }

            size--;
            return value;
        }

        throw new RuntimeException("Empty list");
    }


    private Termino<T> getTermino(int index) {

        if(index >= 0 && index < size) {

            Termino<T> termino = firstTermino;

            for (int i = 0; i < index; i++) {
                termino = termino.getNextTermino();
            }

            return termino;
        }

        return null;
    }


    /**
     * Change the value of a Termino given its position in the list
     * @param index position where the data will be changed
     * @param newValue new value to update the Termino
     */
    public void modifyTermino(int index, T[] newValue) {

        if( validIndex(index) ) {
            Termino<T> termino = getTermino(index);
            termino.setTerminoValue(newValue);
        }

    }


    /**
     * Returns the first position where the data is stored
     * @param data value to search within the list
     * @return first position of the data
     */
    public int getTerminoPosition(T data) {

        int i = 0;

        for( Termino<T> aux = firstTermino ; aux != null ; aux = aux.getNextTermino() ) {
            if( aux.getTerminoValue().equals(data) ) {
                return i;
            }
            i++;
        }

        return -1;
    }


    @Override
    public Iterator<T[]> iterator() {

        return new SimpleTerminoIterator(firstTermino);
    }

    public class SimpleTerminoIterator implements Iterator<T[]> {
        private Termino<T> termino;
        private int position;
        /**
         * Iterator class constructor
         * @param aux First Termino of the list
         */
        public SimpleTerminoIterator(Termino<T> termino) {
            this.termino = termino;
            this.position = 0;
        }
        @Override
        public boolean hasNext() {
            return termino != null;
        }
        @Override
        public T[] next() {
            T[] value = termino.getTerminoValue();
            termino = termino.getNextTermino();
            position++;
            return value;
        }
        /**
         * Current position in the list
         * @return position
         */
        public int getPosition() {
            return position;
        }

    }


    //Getters and setters of the SimpleList class


    public Termino<T> getFirstTermino() {
        return firstTermino;
    }


    public void setFirstTermino(Termino<T> firstTermino) {
        this.firstTermino = firstTermino;
    }


    public int size() {
        return size;
    }


    //Extra methods
    public Collection<T[]> toCollection(){
        Collection<T[]> c = new ArrayList<>();
        Termino<T> aux = firstTermino;
        while(aux != null) {
            c.add(aux.getTerminoValue());
            aux = aux.getNextTermino();
        }
        return c;
    }
    public Polinomio<T> copy(){

        Polinomio<T> copy = new Polinomio<>();
        Termino<T> aux = firstTermino;
        while(aux != null) {
            copy.add(aux.getTerminoValue());
            aux = aux.getNextTermino();
        }
        return copy;

    }
    public void sort(){
        //Implement sorting logic here
    }

    public static Polinomio merge(Polinomio a, Polinomio b){
        Polinomio c = a.copy();
        c.lastTermino.setNextTermino(b.copy().firstTermino);
        return c;

    }

}
