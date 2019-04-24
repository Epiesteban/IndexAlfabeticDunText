package estructuradades;

import java.util.Arrays;
import java.util.Iterator;

import TAD.TADLlistaGenerica;
import excepcions.LlistaBuida;
import excepcions.LlistaPlena;

/**
 * Llista Generica
 * 
 * @author Eric Pi Jordi Toda
 * @version 2.0
 * 
 */
public class LlistaGenerica<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T> {
	private T[] llista;
	private int num;

	/**
	 * Constructor de la classe LlistaGenerica
	 * 
	 * @param dim
	 *            Dimensio de la llista Generica estatica
	 */
	@SuppressWarnings("unchecked")
	public LlistaGenerica(int dim) {
		llista = (T[]) new Comparable[dim];
		num = 0;
	}

	public void afegirElement(T p) throws LlistaPlena {
		if (esPlena())
			throw new LlistaPlena();
		else {
			if (!conte(p)) {
				llista[num] = p;
				num++;
			}
		}
	}

	public T consultarElement(int i) throws LlistaBuida {
		if (num == 0)
			throw new LlistaBuida();
		if (i < num && i >= 0)
			return (llista[i]);
		else
			return (null);
	}

	public int getNum() {
		return num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Arrays.toString(llista);
	}

	@Override
	public Iterator<T> iterator() {
		MeuIterator<T> pI = null;
		;
		try {
			pI = new MeuIterator<T>(this);
		} catch (LlistaPlena | LlistaBuida e) {
			e.printStackTrace();
		}
		return pI;
	}

	@Override
	public boolean esBuida() {
		return num == 0;
	}

	@Override
	public int numElem() {
		return num;
	}

	@Override
	public boolean esPlena() {
		return num == llista.length;
	}

	@Override
	public int index(T e) {
		int index = 0;
		while (index < num && llista[index].compareTo(e) != 0) {
			index++;
		}
		return index < num ? index : -1;
	}

	@Override
	public boolean conte(T e) {
		return index(e) != -1;
	}

	@Override
	public void esborrarElement(T e) throws LlistaBuida {
		int i = 0;
		if (esBuida()) {
			throw new LlistaBuida();

		} else {
			if (conte(e)) {
				i = index(e);
				llista[i] = null;
				while (i < num - 1) {
					llista[i] = llista[i + 1];
					i++;
				}

				num--;
			}
		}

	}

}
