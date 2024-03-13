package punto09;

import javax.naming.directory.SearchControls;

public class Punto9 {

	public static void main(String[] args) {
		SimpleCircularList<String> c = new SimpleCircularList<>();
		c.add("Juan");
		c.add("Valentina");
		c.add("Breyner");
		c.add("Pablo");
		System.out.println(c.search("Valentina"));
		c.insertNode(3, "Camila");
		c.printList();
	}


}
