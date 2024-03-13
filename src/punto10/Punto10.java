package punto10;

public class Punto10 {

    public static void main(String[] args) {
		SimpleList <String> c = new SimpleList<>();
		c.add("hola");
		c.add("bye");
		SimpleList <String> d = new SimpleList<>();
		d.add("Juan");
		d.add("Karen");
		SimpleList<String> e = merge(c, d);
		c.printList();
		d.printList();
		e.printList();
	}

    public static SimpleList merge(SimpleList a, SimpleList b){
		SimpleList c = a.copy();
    	c.getLastNode().setNextNode(b.copy().getFirstNode());
    	return c;

    }

}
