package punto01_02_03_04_13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Lists<E> implements Iterable<E> {

	private Node firstNode;
	private int size;

	/**
	 * create list empty
	 */
	public Lists() {
		firstNode=null;
		size=0;
	}

	//1
	/**
	 * add node at the first position
	 * @param fact
	 */
	public void addFirstNodo(E fact) {
		Node nodo= new Node(fact);
		if(firstNode==null) {
			firstNode=nodo;
		}
		else {
			nodo.setNextNode(firstNode);
			firstNode=nodo;
		}
		size++;
	}

	/**
	 *
	 */


	/**
	 * add Node at the last position
	 * @param fact
	 */
		public void add(E fact) {
			Node n= firstNode;
			if(n!=null) {
				for(int i=1;i<size;i++) {
					n=n.getNextnode();
				}
			n.setNextNode(new Node(fact));
			}else {firstNode = new Node(fact);}
			size++;
		}

		/**
		 * add node in position next of size1
		 * @param fact
		 * @param size1
		 */
		public void add(E fact,int size1) {
			if(isEmpty()) {
				System.out.println("lista Vacia");
			}else {
				Node n=firstNode;
				for(int i=1;i<size1;i++) {
					n=n.getNextnode();
				}
				Node next=n.getNextnode();
				n.setNextNode(new Node(fact));
				n=n.getNextnode();
				n.setNextNode(next);
//				n.getNextnode().setNextNode(n.getNextnode());
//				n.getNextnode().setInformacion(fact);
				size++;
			}
		}
		/**
		 * add node in position next of node
		 * @param fact
		 * @param n
		 */
		public void add(E fact,Node n) {
			if(isEmpty()) {
				System.out.println("vacia");
			}else {
			Node nodo;
			for(nodo = firstNode;nodo!=null;nodo=nodo.getNextnode()) {
				if(nodo.equals(n)) {
					Node nAux=nodo.getNextnode();
					nodo.setNextNode(new Node(fact));
					nodo=nodo.getNextnode();
					nodo.setNextNode(nAux);
				}
				}
			size++;
			}
		}

		/**get information of Node
		 *
		 * @param n
		 * @return
		 */
		public E getValueNode(Node n){
			return (E) n.getInformation();
		}

		/**
		 * get position of node
		 * @param n
		 * @return
		 */
		public int getPosNode(Node n){
			int pos=-1;
			if(isEmpty()){
				System.out.println("Lista vacia");
			}else{
				Node nodo=firstNode;
				for(int i=1;i<size;i++) {
					if(n.equals(nodo)) {
						pos=i;
						break;
					}
					n=n.getNextnode();
				}
			}
		return pos;}

		public boolean indiceValid(int i){
			return i<size;
		}

	/**
	 *  check if the list is empty
	 * @return
	 */
	public boolean isEmpty() {
		if(firstNode==null) {
			return true;
		}else {return false;}
	}


	/**
	 * delete the first Node
	 */
	public void removefirstNode() {
		if(firstNode!=null) {
			if(firstNode.getNextnode()!=null) {
				firstNode=firstNode.getNextnode();
				size--;
			}
		}
	}
	/**
	 * remove last node
	 */
	public void removeLastNode() {
		if(firstNode!=null) {
			Node indice=firstNode;
			for(int i=1;i<size;i++) {
				if(i==size-1) {
					indice.setNextNode(null);
					size--;
					break;
				}else {indice=indice.getNextnode();}
			}
		}
	}

	/**
	 * remove node with fact x
	 * @param f
	 */
	public void remove(E f) {
		Node nodo=firstNode;
		if(nodo!=null) {
			if(nodo.getInformation().equals(f)) {
				firstNode=nodo.getNextnode();
			}else {
				for(int i=0;i<size;i++) {
					if(nodo.getNextnode().getInformation().equals(f)){
						nodo.setNextNode(nodo.getNextnode().getNextnode());
						break;
					}else {
						nodo=nodo.getNextnode();
					}
				}
			}
			size--;
		}else {System.out.println("lista Vacias");}
	}

	/**
	 * set value Node
	 * @param fact
	 * @param n
	 */
	public void setValueNode(E fact,Node n){
		Node ind;
		for(ind=firstNode;ind!=null;ind=ind.getNextnode()){
			if(ind.equals(n)){
				ind.setInformacion(fact);
				break;
			}
		}

	}


	/**
	 * vaciar lista
	 */
	public void clear(){
		firstNode=null;
	}


	/**
	 * traverse the list
	 */
	public void traverseList() {
	Node node=firstNode;
		for(int i=0;i<size;i++) {
			System.out.println(node.getInformation());
			if(node.getNextnode()!=null) {
				node=node.getNextnode();
			}else {break;}
		}
	}
	/**
	 * Iterator
	 *
	 * @param <E>
	 */
	 private class ListstIterator<E> implements Iterator<E> {
	        private Node<E> nodeAct = firstNode;

	        public boolean hasNext() {
	            return nodeAct != null;
	        }

	        public E next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            E data = nodeAct.getInformation();
	            nodeAct = nodeAct.getNextnode();
	            return data;
	        }
	    }


	/**
	 * to locate position of the fact
	 * @param facto
	 * @return
	 */
	public int locate(E facto) {
		if(isEmpty()) {
			System.out.println("lista vacia");
			return -1;
		}else {
			Node n=firstNode;
			for(int i=0;i<size;i++) {
				if(n.getInformation().equals(facto)) {
					return i;
				}
				n=n.getNextnode();
			}
		return -1;}
	}
	/**
	 * search
	 * @param facto
	 * @return
	 */
	public Node searchElement(E facto) {
		Node indice;
		for(indice=firstNode;indice!=null;indice.getNextnode()) {
			if(facto.equals(indice.getInformation())) {
				return indice;
			}
		}
		return null;
	}



	public Node getFirstNode() {
		return firstNode;
	}


	public void setFirstNode(Node firstNode) {
		this.firstNode = firstNode;
		size++;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * iterator creation
	 */
	public Iterator<E> iterator() {
		return new ListstIterator<E>();
	}









}
