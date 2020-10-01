package application.model;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class Tillæg {

	private String navn;
	private double pris;

	public Tillæg(String navn, double pris) {
		this.navn = navn;
		this.pris = pris;
	}

	public String getName() {
		return navn;
	}

	public double getPrice() {
		return pris;
	}

//	public String toString() {
//		return navn + " (kr. " + pris + ")";
//	}

}
