import java.util.Objects;

public class KlientKawiarni {

    private int idKlienta;
    private String imie;
    private String nazwisko;
    private String email;

    public KlientKawiarni(int idKlienta, String imie, String nazwisko, String email) {
        this.idKlienta = idKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public String getPelnyOpis() {
        return "Klient #" + idKlienta + ": " + imie + " " + nazwisko + " <" + email + ">";
    }

    @Override
    public String toString() {
        return getPelnyOpis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KlientKawiarni)) return false;
        KlientKawiarni other = (KlientKawiarni) o;
        return this.idKlienta == other.idKlienta || Objects.equals(this.email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKlienta, email);
    }
}
