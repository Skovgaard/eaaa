package application.model;

import java.util.ArrayList;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class Deltager {

	private String navn;
	private String adresse;
	private String by;
	private String land;
	private String tlfNr;
	private String firmaNavn;
	private String firmaTlfNr;
	private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

	public Deltager(String navn, String adresse, String by, String land, String tlfNr, String firmaNavn,
			String firmaTlfNr) {
		this.navn = navn;
		this.adresse = adresse;
		this.by = by;
		this.land = land;
		this.tlfNr = tlfNr;
		this.firmaNavn = firmaNavn;
		this.firmaTlfNr = firmaTlfNr;
	}

	public void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding))
			tilmeldinger.add(tilmelding);
	}

	public void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding))
			tilmeldinger.remove(tilmelding);
	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return tilmeldinger;
	}

	public String getName() {
		return navn;
	}

	public String getAdress() {
		return adresse;
	}

	public String getCity() {
		return by;
	}

	public String getLand() {
		return land;
	}

	public String getTlfNr() {
		return tlfNr;
	}

	public String getCompanyName() {
		return firmaNavn;
	}

	public String getCompanyTlfNr() {
		return firmaTlfNr;
	}

}
