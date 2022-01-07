package dbbiblioteca;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 * Una biblioteca vorrebbe creare un piccolo database dei suoi donatori libri, dei libri donati e per i prestiti. I donatori avranno nome/cognome, libri: titolo e 
codice(createlo voi manualmente a 3 cifrem). Alla voce database dovrà apparire un'arraylist che stampi tutte le informazioni sui prestiti(cognome, codice libro 
e titolo libro). 
 * */

public class main_dbbiblio {
	
	public static void menu() {
		System.out.println("\n\n--MENU'--\n");
		System.out.println("10] Menu'\n");
		System.out.println("1] Inserisci Utente\n");
		System.out.println("2] Inserisci Libro\n");
		System.out.println("3] Inserisci Prestito\n");
		System.out.println("4] Stampa la biblioteca\n");
		System.out.println("0] Esci\n");
		System.out.println("--> Digita un numero: ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Prestito> DatabasePrestiti = new HashSet<>();
		HashSet<Utente> DatabaseUtenti = new HashSet<>();
		HashSet<Libro> DatabaseLibri = new HashSet<>();
		
		Scanner scanner = new Scanner(System.in);
		int scelta=0;
		menu();
		int id_libri=100; //a 3 cifre
		do {
			System.out.println("\nScelta: ");
			scelta=scanner.nextInt();
			
			switch(scelta) {
			case 10:
				menu();
				break;
			case 1:
				//Add utente
				Scanner scannerNextLineSkipperSolver1 = new Scanner(System.in);
				System.out.println("\n--Aggiungi Utente) \nNome: ");
				String nome = scannerNextLineSkipperSolver1.nextLine(); 
				System.out.println("\nCognome: ");
				String cognome = scannerNextLineSkipperSolver1.nextLine();
				Utente utente = new Utente(nome, cognome);
				DatabaseUtenti.add(utente);
				System.out.println("\nUtente aggiunto");
				break;
			case 2:
				int i;
				Scanner scannerNextLineSkipperSolver2 = new Scanner(System.in);
				System.out.println("\n--Aggiungi Libro) \nTitolo: ");
				String titolo = scannerNextLineSkipperSolver2.nextLine();
				
				Libro libro = new Libro(titolo, id_libri); //id_libri = codice
				id_libri++; //auto increment
				DatabaseLibri.add(libro);
				System.out.println("\nLibro aggiunto");
				break;
			case 3:
				Scanner scannerNextLineSkipperSolver3 = new Scanner(System.in);
				System.out.println("\n--Aggiungi Prestito) \nNome: ");
				nome = scannerNextLineSkipperSolver3.nextLine(); 
				System.out.println("\nCognome: ");
				cognome = scannerNextLineSkipperSolver3.nextLine();
				boolean flag_loop_utente = true;
				boolean flag_loop_libro = true;

				for(Utente u : DatabaseUtenti) {
					if((u.getNome().equals(nome)) && u.getCognome().equals(cognome)){
						System.out.println("\nUtente già esistente, inserire l'ID del "
								+ "libro che si vuole noleggiare: ");
						int id_prestito = scanner.nextInt();
						for(Libro l : DatabaseLibri) {
							if(l.getCodice() == id_prestito) {
								System.out.println("\nLibro presente. Il titolo è \""
							+l.getTitolo()+"\".");
								
								Prestito prestito = new Prestito (u,l);
								DatabasePrestiti.add(prestito);
								flag_loop_libro=false;
							}
						}
						if(flag_loop_libro) {
							System.out.println("\nLibro non presente. "
									+ "Si consiglia di consultare la biblioteca.");
						}
						flag_loop_utente=false;
						break;
						
					}
					
				}
				if(flag_loop_utente) {
					System.out.println("\nUtente non presente");
					
					//utente non presente nel DB
					Utente utente_prestito = new Utente(nome, cognome);
					DatabaseUtenti.add(utente_prestito);
					System.out.println("\nUtente aggiunto, inserire l'ID del libro che si vuole noleggiare: \"");
					int id_prestito = scanner.nextInt();
					for(Libro l : DatabaseLibri) {
						if(l.getCodice() == id_prestito) {
							System.out.println("\nLibro presente. Il titolo è \""+l.getTitolo()+"\".");
							
							Prestito prestito = new Prestito (utente_prestito,l);
							DatabasePrestiti.add(prestito);
						}
					}
				}
				break;
			/*case 4:
				
				break;*/
			case 4:
				System.out.println("\n--Stampa Biblioteca) 1-Stampa tutta la biblioteca  \n2- Stampa gli utenti  3- Stampa i libri  4- Stampa i prestiti\n");
				int subscelta=0;
				do {
					subscelta=scanner.nextInt();
					switch(subscelta) {
					case 1: 
						System.out.println("\n-------------------------");
						System.out.println("\n-------------------------");

							for(Utente u:DatabaseUtenti) {
								System.out.println(u.toString());
								}
							System.out.println("\n-------------------------");

							for(Libro l:DatabaseLibri) {
								System.out.println(l.toString());
							}
							System.out.println("\n-------------------------");

							for(Prestito p:DatabasePrestiti) {
								System.out.println(p.toString());
								System.out.println("\n-------------------------");
								System.out.println("\n-------------------------");

							}
						break;
					case 2:
						
					case 0:
						System.out.println("\nStampa finita.");
						break;
					default:
						System.out.println("\nFeature is Work in progress");
					}
				}while(subscelta!=0);
				break;
			case 0:
				System.out.println("\nAlla prossima.\n");
				break;
			default:
				System.out.println(scelta+"\n non è un opzione.\n");
			}
		}while(scelta!=0);
		
		
		//Database.add()
		
		
	}

}
