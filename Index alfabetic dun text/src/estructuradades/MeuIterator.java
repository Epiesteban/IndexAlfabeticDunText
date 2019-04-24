package estructuradades;

import java.util.Iterator;

import excepcions.LlistaBuida;
import excepcions.LlistaPlena;

/**
 * Iterator per llistes estatiques
 * 
 * @author Eric Pi Jordi Toda
 * @version 2.0
 * 
 */
public class MeuIterator<T extends Comparable<T>> implements Iterator<T> {
	private LlistaGenerica<T> llista; // nou atribut que ens guardar� una
										// copia de la llista actual de punts
	private int posicioIterator;

	/**
	 * Constructor de la classe MeuIterator
	 * 
	 * @param llistaGenerica
	 *            Llista que copiarem a la hora de fer la llista iterator
	 * @throws LlistaPlena
	 *             Excepcio per error al intentar afegir a un llista plena
	 * @throws LlistaBuida
	 *             Excepcio per error al intentar treure elements d'una llista
	 *             buida
	 */
	public MeuIterator(LlistaGenerica<T> llistaGenerica) throws LlistaPlena, LlistaBuida {
		llista = new LlistaGenerica<T>(llistaGenerica.getNum());
		for (int i = 0; i < llistaGenerica.getNum(); i++) {
			llista.afegirElement(llistaGenerica.consultarElement(i));
		}
		posicioIterator = 0; // ens preparem per a retornar els elements a
								// partir de la posicio 0
	}

	@Override
	public boolean hasNext() {
		return ((posicioIterator < llista.getNum()));
	}

	@Override
	public T next() {
		T aux = null;
		try {
			aux = llista.consultarElement(posicioIterator);
		} catch (LlistaBuida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		posicioIterator++;
		return aux;
	}

}