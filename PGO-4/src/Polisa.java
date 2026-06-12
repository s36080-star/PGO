import java.util.Objects;

public class Polisa {

    private String numerPolisy;
    private String klient;
    private double skladkaBazowa;
    private int poziomRyzyka;
    private double wartoscPojazdu;
    private boolean czyMaAlarm;
    private boolean czyBezszkodowyKlient;

    private static int liczbaUtworzonychPolis = 0;
    private static final double OPLATA_ADMINISTRACYJNA = 150.0;

    public Polisa(String numerPolisy, String klient, double skladkaBazowa,
                  int poziomRyzyka, double wartoscPojazdu,
                  boolean czyMaAlarm, boolean czyBezszkodowyKlient) {
        this.numerPolisy = numerPolisy;
        this.klient = klient;
        this.skladkaBazowa = skladkaBazowa;
        this.poziomRyzyka = poziomRyzyka;
        this.wartoscPojazdu = wartoscPojazdu;
        this.czyMaAlarm = czyMaAlarm;
        this.czyBezszkodowyKlient = czyBezszkodowyKlient;
        liczbaUtworzonychPolis++;
    }

    public String getNumerPolisy() { return numerPolisy; }
    public String getKlient() { return klient; }
    public double getSkladkaBazowa() { return skladkaBazowa; }
    public int getPoziomRyzyka() { return poziomRyzyka; }
    public double getWartoscPojazdu() { return wartoscPojazdu; }
    public boolean isCzyMaAlarm() { return czyMaAlarm; }
    public boolean isCzyBezszkodowyKlient() { return czyBezszkodowyKlient; }

    public static int pobierzLiczbeUtworzonychPolis() {
        return liczbaUtworzonychPolis;
    }

    public double obliczSkladkeKoncowa() {
        double skladka = skladkaBazowa + OPLATA_ADMINISTRACYJNA;
        skladka += poziomRyzyka * 120.0;
        if (wartoscPojazdu > 60000.0) {
            skladka += 200.0;
        }
        if (czyMaAlarm) {
            skladka -= 100.0;
        }
        if (czyBezszkodowyKlient) {
            skladka *= 0.90;
        }
        return Math.max(skladka, skladkaBazowa);
    }

    public double obliczSkladkeOdnowieniowa() {
        double podstawa = obliczSkladkeKoncowa();
        double odnowienie = podstawa;

        if (poziomRyzyka == 4) {
            odnowienie *= 1.10;
        } else if (poziomRyzyka >= 5) {
            odnowienie *= 1.20;
        }

        if (wartoscPojazdu > 60000.0) {
            odnowienie += 150.0;
        }

        if (czyBezszkodowyKlient) {
            odnowienie *= 0.92;
        }

        if (czyMaAlarm) {
            odnowienie *= 0.95;
        }

        double min = podstawa * 0.90;
        double max = podstawa * 1.25;

        if (odnowienie < min) odnowienie = min;
        if (odnowienie > max) odnowienie = max;

        return Math.round(odnowienie * 100.0) / 100.0;
    }

    public String pobierzPodsumowanieRyzyka() {
        String opis;
        if (poziomRyzyka <= 2) {
            opis = "niskie";
        } else if (poziomRyzyka <= 3) {
            opis = "srednie";
        } else {
            opis = "wysokie";
        }
        return "Polisa " + numerPolisy + " [" + klient + "] - ryzyko: " + opis + " (poziom " + poziomRyzyka + ")";
    }

    @Override
    public String toString() {
        return "Polisa{" +
                "nr='" + numerPolisy + "'" +
                ", klient='" + klient + "'" +
                ", bazowa=" + skladkaBazowa +
                ", ryzyko=" + poziomRyzyka +
                ", pojazd=" + wartoscPojazdu +
                ", alarm=" + czyMaAlarm +
                ", bezszkodowy=" + czyBezszkodowyKlient +
                ", skladkaKoncowa=" + obliczSkladkeKoncowa() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polisa)) return false;
        Polisa other = (Polisa) o;
        return Objects.equals(this.numerPolisy, other.numerPolisy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerPolisy);
    }
}
