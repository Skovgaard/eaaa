package ex7;

public class Bil {

    private String registreringsNummer;
    private String mærke;
    private String model;
    private String farve;

    public Bil(String registreringsNummer, String mærke, String model, String farve) {
        this.registreringsNummer = registreringsNummer;
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
    }

    public String getRegistreringsNummer() {
        return registreringsNummer;
    }

    public void setRegistreringsNummer(String registreringsNummer) {
        this.registreringsNummer = registreringsNummer;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Bil bil = (Bil) o;
//        return registreringsNummer.equals(bil.registreringsNummer) &&
//                mærke.equals(bil.mærke) &&
//                model.equals(bil.model) &&
//                farve.equals(bil.farve);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(registreringsNummer, mærke);
//    }

    @Override
    public String toString() {
        return "Bil{" +
                "registreringsNummer=" + registreringsNummer +
                ", mærke='" + mærke + '\'' +
                ", model='" + model + '\'' +
                ", farve='" + farve + '\'' +
                '}';
    }
}
