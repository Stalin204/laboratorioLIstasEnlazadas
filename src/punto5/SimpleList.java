package punto5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import node.Node;

public class SimpleList<E> implements Iterable<E> {
  Node<E> head;
  int tamano;

  public SimpleList() {
    this.head = null;
    this.tamano = 0;
  }

  public int calculateNumberofTimesThatAnItemRepeats(E data) {
    int centinela = 0;
    Node<E> current = head;
    while (current != null) {
      if (current.getData().equals(data)) {
        centinela += 1;
      }
      current = current.getLink();
    }
    return centinela;
  }

  // Agregamos nodos nuevos al final de la lista simple
  public void add(E data) {
    Node<E> newNode = new Node<E>(data);
    if (head == null) {
      head = newNode;
    } else {
      Node<E> following = head;
      while (following.getLink() != null) {
        following = following.getLink();
      }
      following.setLink(newNode);
    }
    tamano += 1;
  }

  public int lenght() {
    int centinela = 0;
    Node<E> current = head;
    while (current != null) {
      centinela += 1;
      current = current.getLink();
    }
    return centinela;
  }

  public E getElelement(E dat) {

    Node<E> current = head;
    while (current != null) {
      if (current.getData().equals(dat)) {
        return current.getData();
      }
      current = current.getLink();
    }
    return null;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterar();
  }

  private class Iterar implements Iterator<E> {
    private Node<E> current = head;

    @Override
    public boolean hasNext() {

      return current != null;
    }

    @Override
    public E next() {

      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E dat = current.getData();
      current = current.getLink();
      return dat;
    }
  }
}
