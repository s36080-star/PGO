import java.util.Objects;

public class ProduktMenu {

    private String kod;
    private String nazwa;
    private double cena;
    private String kategoria;
    private static int liczbaProduktow = 0;

    public ProduktMenu(String kod, String nazwa, double cena, String kategoria) {
        this.kod = kod;
        this.nazwa = nazwa;
        this.cena = cena;
        this.kategoria = kategoria;
        liczbaProduktow++;
    }

    public String getKod() { return kod; }
    public String getNazwa() { return nazwa; }
    public double getCena() { return cena; }
    public String getKategoria() { return kategoria; }

    public static int getLiczbaProduktow() {
        return liczbaProduktow;
    }

    @Override
    public String toString() {
        return "[" + kod + "] " + nazwa + " (" + kategoria + ") - " + cena + " zł";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduktMenu)) return false;
        ProduktMenu other = (ProduktMenu) o;
        return Objects.equals(this.kod, other.kod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kod);
    }
}
