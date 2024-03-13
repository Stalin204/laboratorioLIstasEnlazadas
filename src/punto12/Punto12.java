package punto12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Punto12 {

	public static void main(String[] args) {
		String ruta = "P:/Mi unidad/My ws/tallerListas/src/punto12/Numeros.txt";
		try {
			CodingTextManager file = new CodingTextManager(ruta,",");
			file.setFileManager(new FileManager(ruta));
			SimpleList<Double> numbers = new SimpleList<>();
			for (String number: file.getObjectList().get(0)) {
				numbers.add(Double.parseDouble(number));
			}
			double media = calcularMedia(numbers);
			double desviacionEstandar = calcularDesviacion(numbers,media);
			System.out.println("la media es: "+media);
			System.out.println("la desviacion estandar es "+desviacionEstandar);
		} catch (FileManagerException | IOException e) {
			e.printStackTrace();
		}


	}



	private static double calcularDesviacion(SimpleList<Double> numbers, double media) {
		Iterator<Double> iterador = numbers.iterator();
		double resultado =0;
		while (iterador.hasNext()) {
			resultado+= Math.pow((iterador.next()-media),2);
		}
		return Math.sqrt(resultado/(numbers.size()-1));
	}





	private static double calcularMedia(SimpleList<Double> numbers) {
		Iterator<Double> iterador = numbers.iterator();
		double resultado = 0;
		while (iterador.hasNext()) {
			resultado+= iterador.next();
		}
		return resultado/numbers.size();
	}

}
