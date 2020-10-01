package storage;

import java.util.ArrayList;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tillæg;
import application.model.Tilmelding;
import application.model.Udflugt;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class Storage {

	private static ArrayList<Konference> konferencer = new ArrayList<>();
	private static ArrayList<Deltager> deltagere = new ArrayList<>();
	private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
	private static ArrayList<Hotel> hoteller = new ArrayList<>();
	private static ArrayList<Tillæg> tillæg = new ArrayList<>();
	private static ArrayList<Udflugt> udflugter = new ArrayList<>();

	// ---------------------------------------------------------------------------------------

	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<Konference>(konferencer);
	}

	public static void addKonference(Konference k) {
		konferencer.add(k);
	}

	public static void removeKonference(Konference k) {
		konferencer.remove(k);
	}

	// ---------------------------------------------------------------------------------------

	public static ArrayList<Deltager> getDeltagere() {
		return new ArrayList<Deltager>(deltagere);
	}

	public static void addDeltager(Deltager d) {
		deltagere.add(d);
	}

	public static void removeDeltager(Deltager d) {
		deltagere.remove(d);
	}

	// ---------------------------------------------------------------------------------------

	public static ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(tilmeldinger);
	}

	public static void addTilmelding(Tilmelding t) {
		tilmeldinger.add(t);
	}

	public static void removeTilmelding(Tilmelding t) {
		tilmeldinger.remove(t);
	}

	// ---------------------------------------------------------------------------------------

	public static ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(hoteller);
	}

	public static void addHotel(Hotel h) {
		hoteller.add(h);
	}

	public static void removeHotel(Hotel h) {
		hoteller.remove(h);
	}

	// ---------------------------------------------------------------------------------------

	public static ArrayList<Tillæg> getTillæg() {
		return new ArrayList<Tillæg>(tillæg);
	}

	public static void addTillæg(Tillæg t) {
		tillæg.add(t);
	}

	public static void removeTillæg(Tillæg t) {
		tillæg.remove(t);
	}

	// ---------------------------------------------------------------------------------------

	public static ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}

	public static void addUdflugt(Udflugt u) {
		udflugter.add(u);
	}

	public static void removeUdflugt(Udflugt u) {
		udflugter.remove(u);
	}

}
