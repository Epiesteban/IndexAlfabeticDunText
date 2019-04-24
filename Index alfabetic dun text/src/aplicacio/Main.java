package aplicacio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import estructuradades.Arbre;
import estructuradades.Node;
import estructuradades.TaulaHash;
import excepcions.LlistaPlena;
import tipus.Paraula;

public class Main {

	public static String nomFitxer;
	public static TaulaHash<Paraula> taulaH;
	public static Arbre taulaA;

	public static void main(String[] args) {
		int cas;
		long inici, fi;
		Scanner teclat = new Scanner(System.in);
		boolean tractar = false;
		String consulta;

		System.out.println("Dona'm el nom del fitxer");
		nomFitxer = teclat.nextLine();
		// nomFitxer = "Text1.txt";

		while (!tractar) {
			System.out.println("Quina estructura vol agafar?\n1.-Taula dispersio\t2.-Arbres\t3.-Sortir");
			cas = teclat.nextInt();
			teclat.nextLine();

			switch (cas) {

			case 1:
				System.out.println("Taula dispersio");
				inici = System.nanoTime();
				try {
					if (llegirFitxer(cas)) {
						fi = System.nanoTime();
						System.out.println("Fitxer llegit correctament");
						System.out.println("Taula dispersio creada en " + (fi - inici) / 1000000 + "ms");
						System.out.println(taulaH.toString());

						System.out.println(
								"Vol consultar si existeix alguna paraula?\nEn cas afirmatiu posi la paraula,  en cas negatiu -1");
						consulta = teclat.nextLine();
						if (!consulta.equals("-1")) {
							Paraula p = new Paraula(consulta);
							System.out.println(taulaH.consultar(p));
						}

					} else {
						System.out.println("Error en l'arxiu ");
					}
				} catch (LlistaPlena e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Arbre TRIe");
				inici = System.nanoTime();
				try {
					if (llegirFitxer(cas)) {
						fi = System.nanoTime();
						System.out.println("Fitxer llegit correctament");
						System.out.println("Arbre creat en " + (fi - inici) / 1000000 + "ms");
						System.out.println(taulaA.toString());

						System.out.println(
								"Vol consultar si existeix alguna paraula?\nEn cas afirmatiu posi la paraula,  en cas negatiu -1");
						consulta = teclat.nextLine();
						if (!consulta.equals("-1")) {
							System.out.println(taulaA.consultar(consulta));
						}

					} else {
						System.out.println("Error en l'arxiu");
					}
				} catch (LlistaPlena e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Sortir");
				tractar = true;
				break;
			default:
				System.out.println("S'ha confos de numero");
				break;

			}
		}

		teclat.close();
	}

	public static boolean llegirFitxer(int tipus) throws LlistaPlena {
		boolean correcte;
		Paraula p;
		Node<Paraula> pH;

		if (tipus == 1) {
			taulaH = new TaulaHash<Paraula>(30);
		} else {
			taulaA = new Arbre();
		}

		try {

			int num_lin = 0, pagina = 0;
			BufferedReader lector = new BufferedReader(new FileReader(nomFitxer));
			StringTokenizer st;
			String linea, paraula;
			linea = lector.readLine();
			while (linea != null) {

				linea = linea.replace('’', ' ');
				linea = linea.replace(',', ' ');
				linea = linea.replace('.', ' ');

				st = new StringTokenizer(linea, "\n");

				while (st.hasMoreTokens()) {

					paraula = st.nextToken(" ");
					if (paraula.charAt(0) != '<') {

						if (paraula.charAt(0) == '$') {

							paraula = paraula.substring(1);
							p = new Paraula(paraula, pagina, num_lin);
							if (tipus == 1) {
								pH = new Node<Paraula>(p, null);
								taulaH.afegir(pH);
							} else {
								taulaA.afegir(paraula, pagina, num_lin);
							}
						} else {
							p = new Paraula(paraula, pagina, num_lin);
							if (tipus == 1) {
								taulaH.modifica(p, pagina, num_lin);
							} else {
								taulaA.modifica(paraula, pagina, num_lin);
							}
						}

					} else {
						paraula = st.nextToken(" ");
						pagina++;
						num_lin = 0;
					}
				}

				linea = lector.readLine();
				num_lin++;
			}

			correcte = true;
			lector.close();

		} catch (FileNotFoundException e) {
			correcte = false;
		} catch (IOException e) {
			correcte = false;
		}

		return correcte;
	}

}