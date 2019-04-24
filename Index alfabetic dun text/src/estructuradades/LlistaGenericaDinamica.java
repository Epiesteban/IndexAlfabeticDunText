package estructuradades;

import java.util.Iterator;

import TAD.TADLlistaGenerica;
import excepcions.LlistaBuida;
import excepcions.LlistaPlena;

/**
 * Llista generica dinamica
 * 
 * @author Eric Pi Jordi Toda
 * @version 2.0
 * 
 */
public class LlistaGenericaDinamica<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T> {
	private Node<T> cim;
	private int cont;

	/**
	 * Constructor de la classe llista generica dinamica on inicialitzem el
	 * contador d'elements a 0
	 */
	public LlistaGenericaDinamica() {
		cim = null;
		cont = 0;
	}

	public void afegirElement(T e) {
		if (!conte(e)) {
			if (esBuida() || cim.getValor().compareTo(e) > 0) {
				cim = new Node<>(e, cim);
			} else {
				Node<T> aux = cim;
				while (aux.getSeguent() != null && aux.getSeguent().getValor().compareTo(e) < 0) {
					aux = aux.getSeguent();
				}
				aux.setSeguent(new Node<>(e, aux.getSeguent()));
			}
			cont++;
		}
	}

	public boolean esBuida() {
		return cont == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if(cim==null){
			return "";
		}
		return "" + cim;
	}

	public boolean esPlena() {
		return false;
	}

	@Override
	public int index(T e) {
		int index = 0;
		Node<T> aux = cim;
		while (aux != null && aux.getValor().compareTo(e) != 0) {
			aux = aux.getSeguent();
			index++;
		}
		return aux != null ? index : -1;
	}

	@Override
	public boolean conte(T e) {
		return index(e) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		IteratorDinamic<T> pI;
		try {
			pI = new IteratorDinamic<T>(this);
			return pI;
		} catch (LlistaBuida | LlistaPlena e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public T consultarElement(int index) {
		Node<T> aux = cim;
		if (index >= cont) {
			return null;
		} else {
			for (int i = 0; i < index; i++) {
				aux = aux.getSeguent();
			}
			return aux.getValor();
		}

	}

	@Override
	public int numElem() {
		return cont;
	}

	@Override
	public void esborrarElement(T e) throws LlistaBuida {
		if (esBuida())
			throw new LlistaBuida();

		else if (conte(e)) {
			Node<T> aux = cim;
			while (aux.getSeguent() != null && !aux.getSeguent().getValor().equals(e)) {
				aux = aux.getSeguent();
			}
			if (aux.getSeguent() != null) {
				aux.setSeguent(aux.getSeguent().getSeguent());
			} else {
				cim = null;
			}
			cont--;
		}

	}
}