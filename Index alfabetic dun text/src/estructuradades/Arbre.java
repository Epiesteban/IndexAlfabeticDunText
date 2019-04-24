package estructuradades;

import TAD.TADArbre;
import excepcions.LlistaPlena;
import tipus.Lletra;
import tipus.Posicio;

/**
 * Arbre trie
 * 
 * @author Eric Pi i Jordi Toda
 * @version 1.0
 *
 */
public class Arbre implements TADArbre {
	Lletra arrel;
	int numParaules;

	/**
	 * Constructor de la classe Arbre on crear una arrel buida
	 * 
	 * @throws LlistaPlena
	 *             Excepcio per quan la llista esta plena
	 */
	public Arbre() throws LlistaPlena {
		arrel = new Lletra('\0');
		numParaules = 0;
	}

	public void afegir(String p, int pag, int lin) {
		int i = 0;
		Lletra aux = new Lletra(p.charAt(0));
		Lletra aux2 = arrel;

		while (i < p.length() && aux2.getLletraSeguent().conte(aux)) {
			aux = new Lletra(p.charAt(i));
			aux2 = aux2.getLletraSeguent().consultarElement(aux2.getLletraSeguent().index(aux));
			i++;
		}

		while (i < p.length()) {
			aux = new Lletra(p.charAt(i));
			aux2.afegirLletra(aux);
			aux2 = aux2.getLletraSeguent().consultarElement(aux2.getLletraSeguent().index(aux));
			i++;
		}

		if (i == p.length()) {
			aux.getPos().afegirElement((new Posicio(pag, lin)));
			numParaules++;
		}

	}

	public void modifica(String p, int pag, int lin) {
		int i = 0;
		Lletra aux = new Lletra(p.charAt(0));
		Lletra aux2 = arrel;

		while (i < p.length() && aux2.getLletraSeguent().conte(aux)) {

			aux2 = aux2.getLletraSeguent().consultarElement(aux2.getLletraSeguent().index(aux));
			i++;
			if (i != p.length())
				aux = new Lletra(p.charAt(i));
			else {
				if (aux2.getPos().numElem() > 0) {
					aux2.getPos().afegirElement((new Posicio(pag, lin)));
				}
			}
		}
	}

	public String consultar(String p) {
		int i = 0;
		Lletra aux = new Lletra(p.charAt(0));
		Lletra aux2 = arrel;
		String ret = "Paraula " + p + " no trobada";

		while (i < p.length() && aux2.getLletraSeguent().conte(aux)) {

			aux2 = aux2.getLletraSeguent().consultarElement(aux2.getLletraSeguent().index(aux));
			i++;
			if (i != p.length())
				aux = new Lletra(p.charAt(i));
			else {
				if (aux2.getPos().numElem() > 0) {
					ret = p + " " + aux2.getPos();
				}
			}
		}
		return ret;
	}

	@Override
	public String toString() {

		return arrel.toString();
	}

}
