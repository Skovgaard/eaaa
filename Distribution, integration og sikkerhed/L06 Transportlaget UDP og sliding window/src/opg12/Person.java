package opg12;

public class Person {

    // Start med at lave en personklasse med attributter id (int), navn (String) og by (String).
    // Navn og by indeholder ikke specialtegnene #, ¤ eller ! - undlad at bruge andre specialtegn, da disse kan anvendes af RegEx.

    private int id;
    private String navn;
    private String by;

    public Person(int id, String navn, String by) {
        this.id = id;
        this.navn = navn;
        this.by = by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", by='" + by + '\'' +
                '}';
    }
}
