package punto01_02_03_04_13;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class mainprueba {

	public static void main(String[] args) {

		Lists lista = new Lists();
		// lista.add(new Persona("manuel",1234));
		// lista.add(new Persona("jose",345));
		// lista.add(new Persona("laura", 15));

		lista.add(2);
		lista.add(2);
		lista.add(4);
		lista.add(3);
		lista.add(8);

		Lista lista2 = new Lista();
		lista2.add(2);
		lista2.add(3);
		lista2.add(3);
		lista2.add(6);
		lista2.add(2);

		// Uncomment each method so you can test it
		// punto1:
		obtenerPosicionesimpares(lista).traverseList();

		// punto2:
		// obtenerCantPar(lista).traverseList();

		// punto3
		// removePar(lista);
		// lista.traverseList();

		// punto4
		// getOddValues(lista).traverseList();

		// punto13
		// System.out.println(calcularDistanciaMaxima(2, lista2));

	}

	/**
	 * 1. obtener posiciones impares de una lista de numeros
	 * 
	 * @param list
	 * @return
	 */
	public static Lists obtenerPosicionesimpares(Lists list) {
		Lists list1 = new Lists();
		Node indice = list.getFirstNode();
		for (int i = 1; i < list.getSize(); i = i + 2) {
			try {
				// if(esImpar((Integer) indice.getInformation())){
				list1.add(i);

			} catch (ClassCastException e) {
				System.out.println("Objeto No reconocido para metodo\nException: " + e.getMessage());

			}
			indice = indice.getNextnode();
		}
		return list1;
	}

	/**
	 * 2. obtener personas que la cedula tenga cantidad de cifras par
	 * 
	 * @param listaPersonas
	 * @return
	 */
	public static Lists obtenerCantPar(Lists<Persona> listaPersonas) {
		Lists lista = new Lists();
		Iterator l = listaPersonas.iterator();
		while (l.hasNext()) {
			try {
				Persona p = (Persona) l.next();
				if (cantPar(p.getCedula())) {
					lista.add(p);
				}
			} catch (ClassCastException e) {
				System.out.println("Objeto No reconocido para metodo\nException: " + e.getMessage());
			}
		}
		return lista;
	}

	public static boolean cantPar(int n) {
		String num = String.valueOf(n);
		return num.length() % 2 == 0;
	}

	public static void removePar(Lists l) {
		Node ind;
		for (ind = l.getFirstNode(); ind != null; ind = ind.getNextnode()) {
			try {
				if (esPar((Integer) ind.getInformation())) {
					l.remove(ind.getInformation());
				}
			} catch (ClassCastException e) {
				System.out.println("Objeto No reconocido para metodo\nException: " + e.getMessage());
				l.remove(ind.getInformation());
			}
		}
	}

	public static boolean esPar(int n) {
		return n % 2 == 0;
	}

	/**
	 * 4. Obtener una lista con los valores impares
	 * 
	 * @param lista
	 * @return
	 */
	public static Lists getOddValues(Lists<Integer> lista) {
		Lists l = new Lists();
		Node<Integer> n;
		for (n = lista.getFirstNode(); n != null; n = n.getNextnode()) {
			try {
				if (esImpar(n.getInformation())) {
					l.add(n.getInformation());
				}
			} catch (ClassCastException e) {
				System.out.println("Objeto No reconocido para metodo\nException: " + e.getMessage());
			}
		}

		return l;
	}

	private static boolean esImpar(int n) {
		return n % 2 != 0;
	}

	/**
	 * 13. obtener cantidad maxima de forma recursiva
	 * 
	 * @param clave
	 * @param lista
	 * @return
	 */

	public static int calcularDistanciaMaxima(int clave, Lista lista) {
		return DistanciaMax(2, lista.inicio, 0, 0);
	}

	public static int DistanciaMax(int clave, NodoLista nodo, int d, int maximaDistancia) {
		if (nodo == null) {
			return maximaDistancia;
		} else {
			if (nodo.dato == clave) {
				if (d != 0 && d > maximaDistancia) {
					return DistanciaMax(clave, nodo.sig, 1, d);
				} else {
					return DistanciaMax(clave, nodo.sig, 1, maximaDistancia);
				}
			} else {
				if (d != 0) {
					return DistanciaMax(clave, nodo.sig, d = d + 1, maximaDistancia);
				} else {
					return DistanciaMax(clave, nodo.sig, d, maximaDistancia);
				}
			}

		}
	}

}
