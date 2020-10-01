package application.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tillæg;
import application.model.Tilmelding;
import application.model.Udflugt;
import storage.Storage;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class Controller {

	// ---------------------------------------------------------------------------------------

	public static Konference createKonference(String navn, LocalDate startDato, LocalDate slutDato,
			LocalDate sidsteTilmeldingsDato, String sted, double dagspris) {
		Konference konference = new Konference(navn, startDato, slutDato, sidsteTilmeldingsDato, sted, dagspris);
		Storage.addKonference(konference);
		return konference;
	}

	public static ArrayList<Konference> getKonferencer() {
		return Storage.getKonferencer();
	}

	// ---------------------------------------------------------------------------------------

	public static Deltager createDeltager(String navn, String adresse, String by, String land, String tlfNr,
			String firmaNavn, String firmaTlfNr) {
		Deltager deltager = new Deltager(navn, adresse, by, land, tlfNr, firmaNavn, firmaTlfNr);
		Storage.addDeltager(deltager);
		return deltager;
	}

//	public static void removeDeltagerFromStorage(Deltager d) {
//		if (Storage.getDeltagere().contains(d))
//			Storage.removeDeltager(d);
//	}

	public static ArrayList<Deltager> getDeltagere() {
		return Storage.getDeltagere();
	}

	// ---------------------------------------------------------------------------------------

	/**
	 * 
	 * Pre: Deltager ekisterer
	 */
	public static Tilmelding createTilmelding(boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato,
			String ledsager, Deltager deltager, Hotel hotel, Konference konference, ArrayList<Udflugt> udflugter,
			ArrayList<Tillæg> tillæg) {
		Tilmelding tilmelding = new Tilmelding(foredragsholder, ankomstDato, afrejseDato, ledsager, deltager, hotel,
				konference, udflugter, tillæg);
		Storage.addTilmelding(tilmelding);
		return tilmelding;
	}

	public static void removeTilmeldingFromKonference(Tilmelding t, Konference k) {
		t.getDeltager().removeTilmelding(t);
		k.removeTilmelding(t);
		if (Storage.getTilmeldinger().contains(t))
			Storage.removeTilmelding(t);
	}

	public static ArrayList<Tilmelding> getTilmeldinger() {
		return Storage.getTilmeldinger();
	}

	// ---------------------------------------------------------------------------------------

	public static Hotel createHotel(String navn, double enkeltPris, double dobbeltPris) {
		Hotel hotel = new Hotel(navn, enkeltPris, dobbeltPris);
		Storage.addHotel(hotel);
		return hotel;
	}

	public static void addHotelToKonference(Hotel h, Konference k) {
		k.addHotel(h);
	}

	public static void removeHotelFromKonference(Hotel h, Konference k) {
		k.removeHotel(h);
	}

	public static ArrayList<Hotel> getHoteller() {
		return Storage.getHoteller();
	}

	// ---------------------------------------------------------------------------------------

	public static Tillæg createTillægForHotel(String navn, double pris, Hotel hotel) {
		Tillæg tillæg = new Tillæg(navn, pris);
		hotel.createTillæg(tillæg);
		Storage.addTillæg(tillæg);
		return tillæg;
	}

	public static void removeTillægFromHotel(Tillæg t, Hotel h) {
		h.removeTillæg(t);
		Storage.removeTillæg(t);
	}

	// ---------------------------------------------------------------------------------------

	public static Udflugt createUdflugt(String navn, String sted, LocalDate dato, double pris, boolean frokost,
			Konference konference) {
		Udflugt udflugt = new Udflugt(navn, sted, dato, pris, frokost);
		konference.createUdflugt(udflugt);
		Storage.addUdflugt(udflugt);
		return udflugt;
	}

	public static void removeUdflugtFromKonference(Udflugt u, Konference k) {
		k.removeUdflugt(u);
		Storage.removeUdflugt(u);
	}

	// ---------------------------------------------------------------------------------------

	public static void init() {
		initStorage();
	}

	public static void initStorage() {

		// Bruger version 2

		Konference k1 = createKonference("Hav og himmel", LocalDate.of(2019, 11, 27), LocalDate.of(2019, 11, 29),
				LocalDate.of(2019, 11, 25), "Odense Universitet", 1500);
		Konference k2 = createKonference("Test konference", LocalDate.of(2019, 11, 27), LocalDate.of(2019, 11, 29),
				LocalDate.of(2019, 11, 25), "Test sted", 999);

		Hotel h1 = createHotel("Den hvide svane", 1050, 1250);
		addHotelToKonference(h1, k1);
		Tillæg h1t1 = createTillægForHotel("WIFI", 50, h1);
		Tillæg h1t2 = createTillægForHotel("Bad", 50, h1);
		Tillæg h1t3 = createTillægForHotel("Mad", 50, h1);

		Hotel h2 = createHotel("Høtel Phønix", 700, 800);
		addHotelToKonference(h2, k1);
		Tillæg h2t1 = createTillægForHotel("WIFI", 50, h2);
		Tillæg h2t2 = createTillægForHotel("Bad", 50, h2);
//		Tillæg h2t3 = addTillægToHotel("Mad", 50, h2);

		Hotel h3 = createHotel("Pension Tusindfryd", 500, 600);
		Tillæg h3t1 = createTillægForHotel("Morgenmad", 50, h3);

		Udflugt u1 = createUdflugt("Byrundtur", "Odense", LocalDate.of(2019, 11, 27), 125, true, k1);
		Udflugt u2 = createUdflugt("Egeskov", null, LocalDate.of(2019, 11, 28), 75, false, k1);
		Udflugt u3 = createUdflugt("Trapholt Museum", "Kolding", LocalDate.of(2019, 11, 29), 200, true, k1);

		Deltager d1 = createDeltager("Finn Madsen", "Adresse", "By", "Land", "00000000", null, null);
		Tilmelding t1 = createTilmelding(false, LocalDate.of(2019, 11, 27), LocalDate.of(2019, 11, 29), null, d1, null,
				k1, null, null);

		Deltager d2 = createDeltager("Niels Petersen", "Adresse", "By", "Land", "00000000", null, null);
		Tilmelding t2 = createTilmelding(false, LocalDate.of(2019, 11, 27), LocalDate.of(2019, 11, 29), null, d2, h1,
				k1, null, null);

		ArrayList<Tillæg> tillæg1 = new ArrayList<Tillæg>();
		tillæg1.add(h1t1);
//		tillæg1.add(h1t2);
//		tillæg1.add(h1t3);
		ArrayList<Udflugt> udflugter1 = new ArrayList<Udflugt>();
		udflugter1.add(u2);
		udflugter1.add(u3);

		Deltager d3 = createDeltager("Peter Sommer", "Adresse", "By", "Land", "00000000", null, null);
		Tilmelding t3 = createTilmelding(false, LocalDate.of(2019, 11, 27), LocalDate.of(2019, 11, 29), "Mie Sommer",
				d3, h1, k1, udflugter1, tillæg1);

		ArrayList<Tillæg> tillæg2 = new ArrayList<Tillæg>();
		tillæg2.add(h1t1);
		ArrayList<Udflugt> udflugter2 = new ArrayList<Udflugt>();
		udflugter2.add(u1);
		udflugter2.add(u2);

		Deltager d4 = createDeltager("Lone Jensen", "Adresse", "By", "Land", "00000000", null, null);
		Tilmelding t4 = createTilmelding(true, LocalDate.of(2019, 11, 27), LocalDate.of(2019, 11, 29), "Jan Madsen", d4,
				h1, k1, udflugter2, tillæg2);

		ArrayList<Udflugt> udflugter3 = new ArrayList<Udflugt>();
		udflugter3.add(u1);

		Deltager d5 = createDeltager("Ulla Hansen", "Adresse", "By", "Land", "00000000", null, null);
		Tilmelding t5 = createTilmelding(false, LocalDate.of(2019, 11, 27), LocalDate.of(2019, 11, 28), "Hans Hansen",
				d5, null, k1, udflugter3, null);

//		System.out.println("Expected: 4500 Calculated: " + t1.calculatePrice());
//		System.out.println("Expected: 6600 Calculated: " + t2.calculatePrice());
//		System.out.println("Expected: 7375 Calculated: " + t3.calculatePrice());
//		System.out.println("Expected: 2800 Calculated: " + t4.calculatePrice());
//		System.out.println("Expected: 3125 Calculated: " + t5.calculatePrice());

	}

}
