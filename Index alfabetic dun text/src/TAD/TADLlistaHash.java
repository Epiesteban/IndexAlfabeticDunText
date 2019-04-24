package TAD;

import estructuradades.Node;

/**
 *
 * @author Eric Pi i Jordi Toda
 * @version 1.0
 *
 * @param <T>
 *            Objecte generic amb el que volem treballar
 */
public interface TADLlistaHash<T> {

	/**
	 * Metode per afegir un nou element a la taula
	 * 
	 * @param a
	 *            Node de tipus T que afegim a la taula
	 */
	public void afegir(Node<T> a);

	/**
	 * Metode que retorna el factor de carrega
	 * 
	 * @return Double amb el factor de carrega
	 */
	public double getFactor();

	/**
	 * Metode per consultar un element
	 * 
	 * @param a
	 *            Element de tipus T que volem consultar
	 * @return Element de la taula
	 */
	public T consultar(T a);
}
