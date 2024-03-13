package punto10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * Definition of the Simple List class with Generics
 * @param <T>
 *
 * **/

public class SimpleList<T> implements Iterable<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;


    public SimpleList() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }


    //Basic methods


    //Add to the beginning of the list
    public void addFirst(T nodeValue) {
        Node<T> newNode = new Node<>(nodeValue);
        if(isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        }
        else {
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }
        size++;
    }


    /**
     * Add to the end of the list
     * @param nodeValue
     */
    public void add(T nodeValue) {
        Node<T> node = new Node<>(nodeValue);

        if(isEmpty()) {
            firstNode = lastNode = node;
        } else {
            lastNode.setNextNode(node);
            lastNode = node;
        }
        size++;
    }


    //Get the value of a Node
    public T getValue(int index) {
        Node<T> tempNode = null;
        int counter = 0;
        if(validIndex(index)){
            tempNode = firstNode;
            while (counter < index) {
                tempNode = tempNode.getNextNode();
                counter++;
            }
        }
        if(tempNode != null)
            return tempNode.getNodeValue();
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
        return(firstNode == null) ? true : false;
    }


    /**
     * Print the linked list to the console
     */
    public void printList() {

        Node<T> aux = firstNode;

        while(aux != null) {
            System.out.print( aux.getNodeValue() + "\t" );
            aux = aux.getNextNode();
        }

        System.out.println();
    }

    //Delete a Node by its value
    public T remove(T data){
        Node<T> node = firstNode;
        Node<T> previous = null;
        Node<T> next = null;
        boolean found = false;

        //find previous node
        while(node != null) {
            if( node.getNodeValue() == data ) {
                found = true;
                break;
            }
            previous = node;
            node = node.getNextNode();
        }

        if(found) {
            next = node.getNextNode();
            if( previous == null ) {
                firstNode = next;
            } else {
                previous.setNextNode(next);
            }

            if(next == null) {
                lastNode = previous;
            } else {
                node.setNextNode(null);
            }

            node = null;
            size--;
            return data;
        }
        throw new RuntimeException("Element does not exist");
    }


    //Delete the first node of the list
    public T removeFirst() {

        if( !isEmpty() ) {
            Node<T> n = firstNode;
            T value = n.getNodeValue();
            firstNode = n.getNextNode();

            if(firstNode == null) {
//              lastNode = null;
            }

            size--;
            return value;
        }

        throw new RuntimeException("Empty list");
    }


    private Node<T> getNode(int index) {

        if(index >= 0 && index < size) {

            Node<T> node = firstNode;

            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
            }

            return node;
        }

        return null;
    }


    /**
     * Change the value of a node given its position in the list
     * @param index position where the data will be changed
     * @param newValue new value to update the node
     */
    public void modifyNode(int index, T newValue) {

        if( validIndex(index) ) {
            Node<T> node = getNode(index);
            node.setNodeValue(newValue);
        }

    }


    /**
     * Returns the first position where the data is stored
     * @param data value to search within the list
     * @return first position of the data
     */
    public int getNodePosition(T data) {

        int i = 0;

        for( Node<T> aux = firstNode ; aux != null ; aux = aux.getNextNode() ) {
            if( aux.getNodeValue().equals(data) ) {
                return i;
            }
            i++;
        }

        return -1;
    }


    @Override
    public Iterator<T> iterator() {

        return new SimpleListIterator(firstNode);
    }

    public class SimpleListIterator implements Iterator<T> {
        private Node<T> node;
        private int position;
        /**
         * Iterator class constructor
         * @param aux First Node of the list
         */
        public SimpleListIterator(Node<T> node) {
            this.node = node;
            this.position = 0;
        }
        @Override
        public boolean hasNext() {
            return node != null;
        }
        @Override
        public T next() {
            T value = node.getNodeValue();
            node = node.getNextNode();
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


    public Node<T> getFirstNode() {
        return firstNode;
    }


    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }


    public int size() {
        return size;
    }


    //Extra methods
    public Collection<T> toCollection(){
        Collection<T> c = new ArrayList<>();
        Node<T> aux = firstNode;
        while(aux != null) {
            c.add(aux.getNodeValue());
            aux = aux.getNextNode();
        }
        return c;
    }
    public SimpleList<T> copy(){

    	SimpleList<T> copy = new SimpleList<>();
    	Node<T> aux = firstNode;
        while(aux != null) {
            copy.add(aux.getNodeValue());
            aux = aux.getNextNode();
        }
        return copy;

    }



    public Node<T> getLastNode() {
		return lastNode;
	}


	public void setLastNode(Node<T> lastNode) {
		this.lastNode = lastNode;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public void sort(){
        //Implement sorting logic here
    }

}
