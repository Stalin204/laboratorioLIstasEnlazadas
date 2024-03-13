package punto01_02_03_04_13;
public class Lista {
	NodoLista inicio;

	public Lista( ) {
		super();
		inicio = null;
	}


	public void add(int clave) {
		NodoLista n=null;
		if(inicio!=null) {
			NodoLista ind;
			for(ind=inicio;ind!=null;ind=ind.sig) {
				n=ind;
			}
		n.sig=new NodoLista(clave,null);
		}else {inicio = new NodoLista(clave,null);}
	}

}
