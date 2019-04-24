package tipus;

import estructuradades.LlistaGenericaDinamica;

/**
 * 
 * @author Eric Pi i Jordi Toda
 * @version 1.0
 *
 */
public class Lletra implements Cloneable, Comparable<Lletra> {
	private char lletra;
	private LlistaGenericaDinamica<Lletra> LletraSeguent = new LlistaGenericaDinamica<Lletra>();
	private LlistaGenericaDinamica<Posicio> pos = new LlistaGenericaDinamica<Posicio>();

	/**
	 * Construcotr de la classe Lletra
	 * 
	 * @param ll
	 *            Char de la lletra que vols guardar
	 */
	public Lletra(char ll) {
		lletra = ll;
	}

	/**
	 * Metode per afegir una nova lletra a la llista i aixi tindre-les
	 * encadenades
	 * 
	 * @param a
	 *            Lletra que volem unir amb aquesta
	 */
	public void afegirLletra(Lletra a) {
		LletraSeguent.afegirElement(a);
	}

	/**
	 * Metode que retorna la llista de posicions
	 * 
	 * @return pos Llista generica dinamica de posicions on hem trobat la
	 *         paraula
	 */
	public LlistaGenericaDinamica<Posicio> getPos() {
		return pos;
	}

	@Override
	public String toString() {
		String ret = "";
		if (lletra != '\0') {
			ret = "" + lletra;
		}

		if (LletraSeguent != null) {
			ret = ret + LletraSeguent.toString();
		}
		if (pos != null) {
			ret = ret + " " + pos.toString();
		}
		return ret;
	}

	/**
	 * Metode que retorna la llista dinamica de lletres seguents
	 * 
	 * @return Llista generica dinamica de Lletres que son les lletres seguents
	 *         de les paraules emmagatzemades
	 */
	public LlistaGenericaDinamica<Lletra> getLletraSeguent() {
		return LletraSeguent;
	}

	@Override
	public int compareTo(Lletra o) {
		if (lletra == o.lletra)
			return 0;
		else if (lletra < o.lletra)
			return -1;
		else
			return 1;

	}
}
