package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class Tilmelding {

	private boolean foredragsholder;
	private LocalDate ankomstDato;
	private LocalDate afrejseDato;
	private String ledsager;
	private Deltager deltager;
	private Hotel hotel;
	private Konference konference;
	private ArrayList<Udflugt> udflugter = new ArrayList<>();
	private ArrayList<Tillæg> tillæg = new ArrayList<>();

	public Tilmelding(boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato, String ledsager,
			Deltager deltager, Hotel hotel, Konference konference, ArrayList<Udflugt> udflugter,
			ArrayList<Tillæg> tillæg) {
		this.foredragsholder = foredragsholder;
		this.ankomstDato = ankomstDato;
		this.afrejseDato = afrejseDato;
		this.ledsager = ledsager;
		this.deltager = deltager;
		this.hotel = hotel;
		this.konference = konference;
		this.udflugter = udflugter;
		this.tillæg = tillæg;

		deltager.addTilmelding(this);
		konference.createTilmelding(this);
	}

	public String getName() {
		return deltager.getName();
	}

	public boolean getForedragsholder() {
		return foredragsholder;
	}

	public String getForedragsholderJaNej() {
		return foredragsholder ? "Ja" : "Nej";
	}

	public LocalDate getAnkomstDato() {
		return ankomstDato;
	}

	public LocalDate getAfrejseDato() {
		return afrejseDato;
	}

	public String getLedsager() {
		return ledsager;
	}

	public Deltager getDeltager() {
		return deltager;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public Konference getKonference() {
		return konference;
	}

	public ArrayList<Udflugt> getUdflugter() {
		return udflugter;
	}

	public ArrayList<Tillæg> getTillæg() {
		return tillæg;
	}

	public String getTillægString() {
		String st = "";
		if (tillæg != null) {
			for (Tillæg t : tillæg) {
				if (tillæg.indexOf(t) != 0) {
					st += ", " + t.getName();
				} else {
					st += t.getName();
				}
			}
		}
		return st;
	}

	public String getAdress() {
		return deltager.getAdress();
	}

	public String getCity() {
		return deltager.getCity();
	}

	public String getLand() {
		return deltager.getLand();
	}

	public String getTlfNr() {
		return deltager.getTlfNr();
	}

	public String getCompanyName() {
		return deltager.getCompanyName();
	}

	public String getCompanyTlfNr() {
		return deltager.getCompanyTlfNr();
	}

	public double calculatePrice() {
		int days = afrejseDato.compareTo(ankomstDato);
		double konferencePrice = foredragsholder ? 0 : konference.getDayPrice() * (days + 1);
		double hotelPrice = 0;
		if (hotel != null)
			hotelPrice = ledsager == null ? hotel.getSinglePrice() * days : hotel.getDoublePrice() * days;
		double hotelTillægsPrice = 0;
		if (tillæg != null) {
			for (Tillæg t : tillæg) {
				hotelTillægsPrice += t.getPrice() * days;
			}
		}
		double udflugtPrice = 0;
		if (udflugter != null) {
			for (Udflugt u : udflugter) {
				udflugtPrice += u.getPrice();
			}
		}
		return konferencePrice + hotelPrice + hotelTillægsPrice + udflugtPrice;
	}

	public double getTotalPrice() {
		return calculatePrice();
	}

//	public String toString() {
//		if (ledsager == null)
//			return deltager.getName();
//		else
//			return deltager.getName() + " (" + ledsager + ")";
//	}

}
