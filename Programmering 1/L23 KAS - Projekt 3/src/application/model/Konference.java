package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class Konference {

	private String navn;
	private LocalDate startDato;
	private LocalDate slutDato;
	private LocalDate sidsteTilmeldingsDato;
	private String sted;
	private double dagspris;
	private ArrayList<Hotel> hoteller = new ArrayList<>();
	private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
	private ArrayList<Udflugt> udflugter = new ArrayList<>();

	public Konference(String navn, LocalDate startDato, LocalDate slutDato, LocalDate sidsteTilmeldingsDato,
			String sted, double dagspris) {
		this.navn = navn;
		this.startDato = startDato;
		this.slutDato = slutDato;
		this.sidsteTilmeldingsDato = sidsteTilmeldingsDato;
		this.sted = sted;
		this.dagspris = dagspris;
	}

	public void addHotel(Hotel hotel) {
		for (Hotel h : hoteller) {
			if (h.getName() == hotel.getName())
				return;
		}
		if (!hoteller.contains(hotel))
			hoteller.add(hotel);
	}

	public void removeHotel(Hotel h) {
		if (hoteller.contains(h))
			hoteller.remove(h);
	}

	public void createTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding))
			tilmeldinger.add(tilmelding);
	}

	public void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding))
			tilmeldinger.remove(tilmelding);
	}

	public void createUdflugt(Udflugt udflugt) {
		if (!udflugter.contains(udflugt))
			udflugter.add(udflugt);
	}

	public void removeUdflugt(Udflugt udflugt) {
		if (udflugter.contains(udflugt))
			udflugter.remove(udflugt);
	}

	public String getName() {
		return navn;
	}

	public LocalDate getStartDate() {
		return startDato;
	}

	public LocalDate getEndDate() {
		return slutDato;
	}

	public LocalDate getLastRegistrationDate() {
		return sidsteTilmeldingsDato;
	}

	public String getLocation() {
		return sted;
	}

	public double getDayPrice() {
		return dagspris;
	}

//	public String toString() {
//		return navn + "    " + sted + "    " + startDato + "    " + slutDato;
//	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(tilmeldinger);
	}

	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(hoteller);
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}
}
