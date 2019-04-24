package estructuradades;

public class Node<T> implements Cloneable, Comparable<Node<T>> {
	private T valor;
	private Node<T> seguent;

	/**
	 * Constructor de la classe Node
	 * 
	 * @param object
	 *            Objecte de tipus T que volem guardar
	 * @param seg
	 *            Node seguent el qual volem que aquest apunti
	 */
	public Node(T object, Node<T> seg) {
		valor = object;
		seguent = seg;
	}

	/**
	 * Metode que retorna el seguent node
	 * 
	 * @return seguent Seguent node que aquest apunta
	 */
	public Node<T> getSeguent() {
		return seguent;
	}

	/**
	 * Metode que modifica el seguent node
	 * 
	 * @param seguent
	 *            Seguent node que aquest apunta
	 */
	public void setSeguent(Node<T> seguent) {
		this.seguent = seguent;
	}

	@Override
	public String toString() {
		if (seguent != null) {
			return "" + valor + "" + seguent;
		} else
			return "" + valor;
	}

	/**
	 * Metode que retorna el valor del numero
	 * 
	 * @return valor Valor del numero guardat
	 */
	public T getValor() {
		return valor;
	}

	/**
	 * Metode que modifica el valor del numero
	 * 
	 * @param valor
	 *            Valor que volem emmagatzemar
	 */
	public void setValor(T valor) {
		this.valor = valor;
	}

	@Override
	protected Node<T> clone() {
		Node<T> aux = new Node<T>(valor, seguent);
		return aux;
	}

	@Override
	public int compareTo(Node<T> o) {
		return this.compareTo(o);
	}

}
