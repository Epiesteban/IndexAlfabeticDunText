package TAD;

/**
 * 
 * @author Eric Pi i Jordi Toda
 * @version 1.0
 *
 */
public interface TADArbre {

	/**
	 * Metode per afegir una paraula a l'arbre
	 * 
	 * @param p
	 *            String de la paraula
	 * @param pag
	 *            Enter de la pagina
	 * @param lin
	 *            Enter de la linia
	 */
	public void afegir(String p, int pag, int lin);

	/**
	 * Metode per modifica una paraula de l'estructura
	 * 
	 * @param p
	 *            String de la paraula
	 * @param pag
	 *            Enter de la pagina
	 * @param lin
	 *            Enter de la linia
	 */
	public void modifica(String p, int pag, int lin);

	/**
	 * Metode per consultar una paraula a l'estructura
	 * 
	 * @param p
	 *            String de la paraula a consultar
	 * @return String amb la informació d'aquesta
	 */
	public String consultar(String p);

}
