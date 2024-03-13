package punto12;


/**
 * Node class implementing Generics
 */

public class Node<T> {

    private Node<T> nextNode;
    private T nodeValue;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nextNode == null) ? 0 : nextNode.hashCode());
        result = prime * result + ((nodeValue == null) ? 0 : nodeValue.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node<?> other = (Node<?>) obj;
        if (nextNode == null) {
            if (other.nextNode != null)
                return false;
        } else if (!nextNode.equals(other.nextNode))
            return false;
        if (nodeValue == null) {
            if (other.nodeValue != null)
                return false;
        } else if (!nodeValue.equals(other.nodeValue))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Node [nodeValue=" + nodeValue + "]";
    }

    /**
     * Constructor of the Node class
     * @param nodeValue Element to be stored in the Node
     */
    public Node(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    /**
     * Constructor of the Node class
     * @param nodeValue Element to be stored in the Node
     * @param next Reference to the next Node
     */
    public Node(T nodeValue, Node<T> next) {
        super();
        this.nodeValue = nodeValue;
        this.nextNode = next;
    }

    // Getters and setters of the Node class

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(T nodeValue) {
        this.nodeValue = nodeValue;
    }


}
