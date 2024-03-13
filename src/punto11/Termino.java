package punto11;


/**
 * Node class implementing Generics
 */

public class Termino<T extends Number> {

    private Termino<T> nextNode;
    private T coeficiente;
    private T exponente;
	public Termino<T> getNextTermino() {
		return nextNode;
	}
	public void setNextTermino(Termino<T> nextNode) {
		this.nextNode = nextNode;
	}
	public T getCoeficiente() {
		return coeficiente;
	}
	public void setCoeficiente(T coeficiente) {
		this.coeficiente = coeficiente;
	}
	public T getExponente() {
		return exponente;
	}
	public void setExponente(T exponente) {
		this.exponente = exponente;
	}
	@Override
	public String toString() {
		return "Termino [coeficiente=" + coeficiente + ", exponente=" + exponente + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coeficiente == null) ? 0 : coeficiente.hashCode());
		result = prime * result + ((exponente == null) ? 0 : exponente.hashCode());
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
		Termino other = (Termino) obj;
		if (coeficiente == null) {
			if (other.coeficiente != null)
				return false;
		} else if (!coeficiente.equals(other.coeficiente))
			return false;
		if (exponente == null) {
			if (other.exponente != null)
				return false;
		} else if (!exponente.equals(other.exponente))
			return false;
		return true;
	}
	public Termino(T coeficiente, T exponente) {
		super();
		this.coeficiente = coeficiente;
		this.exponente = exponente;
	}
	public Termino(T[] t) {
		super();
		this.coeficiente = t[0];
		this.exponente = t[1];
	}
	public Termino(Termino<T> nextNode, T coeficiente, T exponente) {
		super();
		this.nextNode = nextNode;
		this.coeficiente = coeficiente;
		this.exponente = exponente;
	}
	public Termino() {
		super();
		// TODO Esbozo de constructor generado automáticamente
	}

	public void setTerminoValue(T[] c) {

		setCoeficiente(c[0]);
		setExponente(c[1]);
	}
	public T[] getTerminoValue() {
		T[] t =(T[]) new Number[2];
		t[0] = getCoeficiente();
		t[1] = getExponente();
		return t;
	}










}