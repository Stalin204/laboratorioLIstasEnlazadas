package punto_6_7_8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import node.NodeDoble;

public class DoubleList<E> implements Iterable<E> {
  NodeDoble<E> head;
  NodeDoble<E> previous;
  E dat;

  public DoubleList() {
    this.head = null;
    this.previous = null;
  }

  // Method to add a node to the end of the list
  public void append(E data) {
    NodeDoble<E> newNode = new NodeDoble<>(data); // Create a new node with the provided data
    if (head == null) { // If the list is empty
      head = newNode; // The new node becomes the head of the list
    } else {
      NodeDoble<E> current = head;
      // Move to the last node
      while (current.getSiguiente() != null) {
        current = current.getSiguiente();
      }
      // Connect the new node to the last node
      current.setSiguiente(newNode);
      newNode.setAnterior(current);
    }
  }

  // Method to print the list backwards
  public void printBackwards() {
    NodeDoble<E> current = head;
    // Move to the last node
    while (current.getSiguiente() != null) {
      current = current.getSiguiente();
    }
    // Traverse the list backwards and print each node
    while (current != null) {
      System.out.print(current.getDato() + " <-> ");
      current = current.getAnterior();
    }
    System.out.println("null");
  }

  public boolean CalculatePar(String Data) {

    int centinela = 0;
    boolean auxiliar = true;
    for (int i = 0; i < Data.length(); i += 1) {
      if (Data.charAt(i) >= 48 && Data.charAt(i) <= 57) {
        centinela += 1;
      }
    }
    if (centinela % 2 == 1) {
      auxiliar = false;
    }
    return auxiliar;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterar();
  }

  private class Iterar implements Iterator<E> {
    private NodeDoble<E> current = head;

    @Override
    public boolean hasNext() {

      return current != null;
    }

    @Override
    public E next() {

      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E dat = current.getDato();
      current = current.getSiguiente();
      return dat;
    }
  }
}
