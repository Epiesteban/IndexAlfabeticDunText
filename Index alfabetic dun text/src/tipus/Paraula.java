package tipus;

import estructuradades.LlistaGenericaDinamica;

/**
 * 
 * @author Eric Pi i Jordi Toda
 * @version 1.0
 *
 */
public class Paraula implements Comparable<Paraula> {
	private String paraula;
	private LlistaGenericaDinamica<Posicio> posicions = new LlistaGenericaDinamica<Posicio>();

	/**
	 * Constructor de la classe
	 * 
	 * @param paraula
	 *            String de la paraula que volem emmagatzemar
	 * @param plana
	 *            Pagina on s'ha trobat la paraula
	 * @param linea
	 *            Linia on s'ha trobat la paraula
	 */
	public Paraula(String paraula, int plana, int linea) {
		Posicio pos = new Posicio(plana, linea);
		posicions.afegirElement(pos);
		this.paraula = paraula;
	}

	/**
	 * Constructor de la classe
	 * 
	 * @param p
	 *            Paraula que volem emmagatzemar
	 */
	public Paraula(String p) {
		paraula = p;
	}

	/**
	 * Metode per afegir noves posicions a la llista
	 * 
	 * @param pag
	 *            Pagina on hem trobat la paraula
	 * @param lin
	 *            Linia on hem trobat la paraula
	 */
	public void afegirPosicions(int pag, int lin) {
		posicions.afegirElement(new Posicio(pag, lin));
	}

	/**
	 * Metode que retorna la llista de posicions
	 * 
	 * @return Llista generica dinamica de posicions
	 */
	public LlistaGenericaDinamica<Posicio> getPosicions() {
		return posicions;
	}

	public int hashCode() {
		int idHash = paraula.charAt(0) - 97;

		if (idHash < 0)
			idHash += 32;
		if (idHash < 0)
			idHash = idHash * (-1);

		return (idHash);
	}

	@Override
	public String toString() {
		return "Paraula=" + paraula + " Posicions=" + posicions;
	}

	@Override
	public int compareTo(Paraula o) {
		return paraula.compareTo(o.paraula);

	}

}
