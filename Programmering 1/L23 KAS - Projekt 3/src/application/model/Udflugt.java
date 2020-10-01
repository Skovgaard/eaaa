package application.model;

import java.time.LocalDate;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class Udflugt {

	private String navn;
	private String sted;
	private LocalDate dato;
	private double pris;
	private boolean frokost;

	public Udflugt(String navn, String sted, LocalDate dato, double pris, boolean frokost) {
		this.navn = navn;
		this.sted = sted;
		this.dato = dato;
		this.pris = pris;
		this.frokost = frokost;
	}

	public String getName() {
		return navn;
	}

	public String getPlace() {
		return sted;
	}

	public String getNameAndPlace() {
		if (sted != null)
			return navn + ", " + sted;
		else
			return navn;
	}

	public LocalDate getDate() {
		return dato;
	}

	public double getPrice() {
		return pris;
	}

	public boolean getLunch() {
		return frokost;
	}

	public String getPriceAndBreakfast() {
		if (frokost)
			return pris + " incl. frokost ";
		else
			return pris + "";
	}

	public String toString() {
		if (sted == null)
			return navn;
		else
			return navn + ", " + sted;

	}

}
