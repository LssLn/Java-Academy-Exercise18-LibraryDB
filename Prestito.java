package dbbiblioteca;

import java.util.Objects;

public class Prestito {
	private Utente utente;
	private Libro libro;
	
	public Prestito (Utente utente, Libro libro) {
		this.utente= utente;
		this.libro = libro;
	}

	public Utente getUtente() {
		return utente;
	}

	public Libro getLibro() {
		return libro;
	}

	@Override
	public String toString() {
		return "Prestito [" + utente + ", " + libro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(libro, utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestito other = (Prestito) obj;
		return Objects.equals(libro, other.libro) && Objects.equals(utente, other.utente);
	}

	
}
