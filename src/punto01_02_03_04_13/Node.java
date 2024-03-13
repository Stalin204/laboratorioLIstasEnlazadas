package punto01_02_03_04_13;
import java.util.Iterator;

public class Node <E> {

	private E information;
	private Node<E> nextNode;


	public Node( E information) {

		this.information = information;
		nextNode=null;
	}



	public void setNextNode(Node nextNode) {
		this.nextNode=nextNode;
	}

	public E getInformation() {
		return information;
	}

	public void setInformacion(E information) {
		this.information = information;
	}

	public Node getNextnode() {
		return nextNode;
	}












}
