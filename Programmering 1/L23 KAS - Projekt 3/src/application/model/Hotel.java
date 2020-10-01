package application.model;

import java.util.ArrayList;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class Hotel {

	private String navn;
	private double enkeltPris;
	private double dobbeltPris;
	private ArrayList<Tillæg> tillægsListe = new ArrayList<>();

	public Hotel(String navn, double enkeltPris, double dobbeltPris) {
		this.navn = navn;
		this.enkeltPris = enkeltPris;
		this.dobbeltPris = dobbeltPris;
	}

	public void createTillæg(Tillæg nytTillæg) {
		for (Tillæg t : tillægsListe) {
			if (t.getName() == nytTillæg.getName() && t.getPrice() == nytTillæg.getPrice()) {
				return;
			}
		}
		tillægsListe.add(nytTillæg);
	}

	public void removeTillæg(Tillæg t) {
		if (tillægsListe.contains(t)) {
			tillægsListe.remove(t);
		}
	}

	public String getName() {
		return navn;
	}

	public double getSinglePrice() {
		return enkeltPris;
	}

	public double getDoublePrice() {
		return dobbeltPris;
	}

	public String getDoubleAndSinglePrice() {
		return "Kr. " + getDoublePrice() + "/" + getSinglePrice();
	}

	public ArrayList<Tillæg> getTillæg() {
		return new ArrayList<Tillæg>(tillægsListe);
	}

	public String toString() {
		return navn + " (kr. " + enkeltPris + "/kr. " + dobbeltPris + ")";
	}

}
