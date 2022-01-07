package dbbiblioteca;

import java.util.Objects;

public class Libro {
	private String titolo;
	private int codice;
	
	public Libro(String titolo, int codice) {
		super();
		this.titolo = titolo;
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getCodice() {
		return codice;
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", codice=" + codice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice, titolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return codice == other.codice && Objects.equals(titolo, other.titolo);
	}
	
	
	
}
