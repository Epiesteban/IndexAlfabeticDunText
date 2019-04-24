package estructuradades;

import TAD.TADLlistaHash;
import tipus.Paraula;

/**
 * Taula Hash
 * @author Eric Pi i Jordi Toda
 *
 * @param <T> Classe que guardem a la taula de Hash
 */
public class TaulaHash<T extends Paraula> implements TADLlistaHash<T> {

	private Node<T> taula[];
	private int numElem = 0;

	/**
	 * Constructor de la taula de Hash, on inicialitzem una taula de nodes
	 * @param dim Dimensio de la taula de nodes
	 */
	@SuppressWarnings("unchecked")
	public TaulaHash(int dim) {
		taula = new Node[dim];
	}

	public void afegir(Node<T> a) {
		Node<T> aux;
		int posicio = a.getValor().hashCode() % taula.length;

		if (taula[posicio] == null) {
			taula[posicio] = a;
			numElem++;
		} else {
			aux = a;
			aux.setSeguent(taula[posicio]);
			taula[posicio] = aux;
			numElem++;
		}
	}

	public Node<T>[] getTaula() {
		return taula;
	}

	@Override
	public String toString() {
		String ret = "";

		for (int i = 0; i < taula.length; i++) {
			if (taula[i] != null) {
				ret += taula[i] + "\n";
			}
		}
		return ret;
	}

	public int getNumElem() {
		return numElem;
	}

	public double getFactor() {
		return ((double) numElem / taula.length);
	}

	@Override
	public T consultar(T a) {
		int posicio = a.hashCode()%taula.length;
		if (taula[posicio] != null) {
			Node<T> aux = taula[posicio];
			
			while (aux != null) {
				if (aux.getValor().compareTo(a)==0){
					return aux.getValor();
				}
				aux = aux.getSeguent();
			}
		}

		return null;
	}
	
	public void modifica(Paraula p, int pag, int lin) {
		int pos = p.hashCode() % taula.length;
		boolean trobat = false;
		Node<T> aux = taula[pos];

		while (aux != null && !trobat) {
			if (aux.getValor().compareTo(p) == 0) {
				trobat = true;
				aux.getValor().afegirPosicions(pag, lin);
			}
			aux = aux.getSeguent();
		}
	}


}
