package excepcions;

/**
 * Llista buida
 * 
 * @author Eric Pi Jordi Toda
 * @version 2.0
 * 
 */
public class LlistaBuida extends Exception {
	private static final long serialVersionUID = 1L;

	public LlistaBuida() {
		super("ERROR : Llista buida");
	}

}
