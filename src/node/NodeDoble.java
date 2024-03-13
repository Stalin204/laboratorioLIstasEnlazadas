package node;

public class NodeDoble<E> {
  E dato;
  NodeDoble<E> siguiente;
  NodeDoble<E> anterior;

  public NodeDoble(E dato) {
    this.dato = dato;
    this.siguiente = null;
    this.anterior = null;
  }

  public E getDato() {
    return dato;
  }

  public void setDato(E dato) {
    this.dato = dato;
  }

  public NodeDoble<E> getSiguiente() {
    return siguiente;
  }

  public void setSiguiente(NodeDoble<E> siguiente) {
    this.siguiente = siguiente;
  }

  public NodeDoble<E> getAnterior() {
    return anterior;
  }

  public void setAnterior(NodeDoble<E> anterior) {
    this.anterior = anterior;
  }
}
