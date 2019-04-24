package estructuradades;
import java.util.Iterator;

import excepcions.LlistaBuida;
import excepcions.LlistaPlena;

/**
 * Iterator dinamic
 * @author Eric Pi Jordi Toda
 * @version 2.0
 * 
 */
public class IteratorDinamic<T extends Comparable<T>> implements Iterator<T> {
	private LlistaGenerica<T> llista; // nou atribut que ens guardar una copia
										// de la llista actual de punts
	private int posicioIterator;
	
	/**
	 * Constructor de la classe iterator
	 * 
	 * @param llistaGenericaDinamica
	 *            Llista que volem copiar
	 * @throws LlistaPlena
	 *             Excepcio per error al intentar afegir a un llista plena
	 * @throws LlistaBuida
	 *             Excepcio per error al intentar treure elements d'una llista
	 *             buida
	 */
	public IteratorDinamic(LlistaGenericaDinamica<T> llistaGenericaDinamica) throws LlistaBuida, LlistaPlena {
		llista = new LlistaGenerica<T>(llistaGenericaDinamica.numElem());
		for (int i = 0; i < llistaGenericaDinamica.numElem(); i++) {
			llista.afegirElement(llistaGenericaDinamica.consultarElement(i));
		}
		posicioIterator = 0; // ens preparem per a retornar els elements a
								// partir de la posicio 0
	}

	/**
	 * Metode que retorna boolea si tenim mes elements per llegir
	 * @return cert si hi ha mes elements, fals si es l'ultim
	 */
	@Override
	public boolean hasNext() {
		return ((posicioIterator < llista.numElem()));
	}

	/**
	 * Metode que retorna el seguent objecte de la llist
	 * @return aux Variable de tipus generic que conte el seguent element de la llista, si hi ha elements
	 */
	@Override
	public T next() {
		T aux=null;
		try {
			aux = llista.consultarElement(posicioIterator);
		} catch (LlistaBuida e) {
			e.printStackTrace();
		}
		posicioIterator++;
		return aux;
	}

}
