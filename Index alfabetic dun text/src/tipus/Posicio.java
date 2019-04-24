package tipus;

/**
 * 
 * @author Eric Pi i Jordi Toda
 * @version 1.0
 *
 */
public class Posicio implements Cloneable, Comparable<Posicio> {
	private int pag;
	private int lin;

	/**
	 * Constructor de la classe posicio
	 * 
	 * @param plana
	 *            Pagina on hem trobat la informacio
	 * @param linea
	 *            Linia on hem trobat la informacio
	 */
	public Posicio(int plana, int linea) {
		pag = plana;
		lin = linea;
	}

	/**
	 * Metode privat per comparar la posicio
	 * 
	 * @return String amb la pagina i la linia separats per dos punts
	 */
	private String getPos() {
		return pag + ":" + lin;
	}

	@Override
	public String toString() {
		return "Pagina: " + pag + "\tLinia: " + lin + " | ";
	}

	public int compareTo(Posicio o) {
		return (pag + ":" + lin).compareTo(o.getPos());
	}
}