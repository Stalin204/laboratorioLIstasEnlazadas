package punto11;

import java.util.Iterator;

public class Punto11 {

	public static void main(String[] args) {
		Polinomio<Double> y = new Polinomio<>();
		Double[] x1 = {5.0, 2.0};
		Double[] x2 = {8.0, 4.0};
		Double[] x3 = {6.0, 2.0};
		Double[] x4 = {3.0, 1.0};
		Double[] x5 = {1.0, 3.0};
		Double[] x6 = {5.0, 0.0};

		y.add(x1);
		y.add(x2);
		y.add(x3);
		y.add(x4);
		y.add(x5);
		y.add(x6);
		
		//y.printList();
		obtenerTablaValores(y);
		

	}
	
	public static void obtenerTablaValores(Polinomio y){

		for (float i = (float) 0.0; i <= 5; i=(float) (i+0.5)) {
			System.out.println("x="+i+"  y="+calcularValor(y,i));
		}
	}

	private static Double calcularValor(Polinomio y,Float i) {
			Double total = 0.0;
	        Termino aux = y.getFirstTermino();
	        while(aux != null) {
	        		total+= (Double)aux.getCoeficiente()*Math.pow(i,(Double)aux.getExponente());
	            
	            aux = aux.getNextTermino();
	        }
	        return total;
	}

}
