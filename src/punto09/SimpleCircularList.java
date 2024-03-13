package punto09;

import java.util.Iterator;


/**
 * Definition of the Simple Circular List class with Generics
 * @param <T>
 *
 * **/

public class SimpleCircularList<T> implements Iterable<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;


    public SimpleCircularList() {
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
            Node<T> aux = firstNode;
            newNode.setNextNode(aux);
            lastNode.setNextNode(newNode);
            firstNode= newNode;
        }
        size++;
    }


    //Add to the end of the list
    public void add(T nodeValue) {

        Node<T> newNode = new Node<>(nodeValue);

        if(isEmpty()) {
            firstNode = lastNode = newNode;
        }
        else {

            lastNode.setNextNode(newNode);
            newNode.setNextNode(firstNode);
            lastNode = newNode;
        }
        size++;
    }

    //Get the value of a Node
    public T getValue(int index) {

        Node<T> tempNode = null;
        int counter = 0;

        if(validIndex(index)) {
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
        throw new RuntimeException("Invalid index");
    }


    //Check if the list is empty
    public boolean isEmpty() {
        return (firstNode == null) ? true : false;
    }


    /**
     * Print the linked list to the console
     */
    public void printList() {

        Node<T> aux = firstNode;
        System.out.print( aux.getNodeValue() + "\t" );
        aux = aux.getNextNode();
        while(aux != firstNode) {
            System.out.print( aux.getNodeValue() + "\t" );
            aux = aux.getNextNode();
        }

        System.out.println();
    }

    //Delete a Node by its value
    public T remove(T data){
        Node<T> node = firstNode;
        Node<T> prev = null;
        Node<T> next = null;
        boolean found = false;

        //find the previous node
        while(node != null) {
            if( node.getNodeValue() == data ) {
                found = true;
                break;
            }
            prev = node;
            node = node.getNextNode();
        }

        if(found) {
            next = node.getNextNode();
            if( prev == null ) {
                firstNode = next;
            }else {
                prev.setNextNode(next);
            }

            if(next == null) {
//              lastNode = prev;
            }else {
                node.setNextNode(null);
            }

            node = null;
            size--;
            return data;
        }
        throw new RuntimeException("The element does not exist");
    }


    //Delete the first node of the list
    public T remuveFirst() {

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
    public int search(T data) {

        int i = 0;

        for( Node<T> aux = getFirstNode() ; aux != null ; aux = aux.getNextNode() ) {
            if( aux.getNodeValue().equals(data) ) {
                return i;
            }
            i++;
        }

        return -1;
    }

    //Get the value of a Node
    public void insertNode(int index, T nodeValue) {

        Node<T> tempNode = null;
        int counter = 0;

        if(index >= 0 && index < getSize()) {
        	if(index == 0){
        		addFirst(nodeValue);
        	}else{

	            tempNode = getFirstNode();

	            while (counter < index-1) {

	                tempNode = tempNode.getNextNode();
	                counter++;
	            }


		        if(tempNode != null){

		        	Node<T> newNode = new Node(nodeValue);
		        	newNode.setNextNode(tempNode.getNextNode());
		        	tempNode.setNextNode(newNode);
		        }else{
		        	add(nodeValue);
		        }
        	}
        }
    }

    public T removeLast() {

        if( !isEmpty() ) {
            T value = lastNode.getNodeValue();
            Node<T> prev = getNode(size-2);
            lastNode = prev;

            if(lastNode == null) {
                firstNode=null;
            }else {
                prev.setNextNode(null);
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

        return new SimpleListIterator (firstNode);
    }

    protected class SimpleListIterator implements Iterator<T>{

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


    //Getters and setters of the SimpleCircularList class


    public Node<T> getFirstNode() {
        return firstNode;
    }


    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }


    public int getSize() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }
}
