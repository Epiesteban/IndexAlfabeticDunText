package TAD;

import java.util.Iterator;

import excepcions.LlistaBuida;
import excepcions.LlistaPlena;

/**
 * @author Eric Pi Jordi Toda
 * @version 2.0
 * 
 * @param <T>
 *            Objecte generic amb el que volem treballar
 */
public interface TADLlistaGenerica<T extends Comparable<T>> {

	/**
	 * Aquest m�tode ens permet afegir un element a aquesta llista Gen�rica
	 * 
	 * @param p
	 *            Objecte de tipus T a afegir
	 * @throws LlistaPlena
	 *             Excepcio per error al intentar afegir a un llista plena
	 */
	public void afegirElement(T p) throws LlistaPlena;

	/**
	 * Aquest m�tode ens permet esborrar un element de la llista Gen�rica
	 * 
	 * @param e
	 *            Objecte de tipus T a esborrar
	 * @throws LlistaBuida
	 *             Excepcio per error al intentar treure elements d'una llista
	 *             buida
	 */
	public void esborrarElement(T e) throws LlistaBuida;

	/**
	 * Aquest m�tode ens permet consultar un determinat element de la llista
	 * 
	 * @param i
	 *            Posicio de l'element dins de la llista
	 * @return Objecte de tipus T que hem llegit de la llista
	 * @throws LlistaBuida
	 *             Excepcio per error al intentar treure elements d'una llista
	 *             buida
	 */
	public T consultarElement(int i) throws LlistaBuida;

	/**
	 * Aquest m�tode ens permet consultar si la llista est� buida
	 * 
	 * @return cert si es buida fals en cas contrari
	 */
	public boolean esBuida();

	/**
	 * Aquest m�tode ens permet consultar el numero d�elements que hi ha a la
	 * llista
	 * 
	 * @return Numero d'elements de la llista
	 */
	public int numElem();

	/**
	 * Aquest m�tode ens permet consultar si la llista est� plena
	 * 
	 * @return cert si es plena fals en cas contrari
	 */
	public boolean esPlena();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString();

	/**
	 * Aquest m�tode ens retorna l�index on hi ha un objecte determinat dins la
	 * llista
	 * 
	 * @param e
	 *            Objecte que volem cercar a la llista
	 * @return Enter que sera la posicio dins de la llista
	 */
	public int index(T e);

	/**
	 * Aquest m�tode ens retorna un boole� conforme un objecte est� dins la
	 * llista o no
	 * 
	 * @param e
	 *            Objecte de tipus T que volem cercar a la llista
	 * @return cert si esta a la llista fals en cas contrari
	 */
	public boolean conte(T e);

	/**
	 * Aquest m�tode copia la llista que li passes a una de nova
	 * 
	 * @return llista d'terator d'objectes T
	 */
	public Iterator<T> iterator();
}
