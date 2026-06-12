public class Programista extends Pracownik {

    private String glownyJezyk;
    private int liczbaRepozytoriow;

    public Programista(String idPracownika, String imie, String nazwisko,
                       double stawkaBazowa, String glownyJezyk, int liczbaRepozytoriow) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.glownyJezyk = glownyJezyk;
        this.liczbaRepozytoriow = liczbaRepozytoriow;
    }

    @Override
    public double obliczKosztMiesieczny() {
        double koszt = getStawkaBazowa();
        koszt += liczbaRepozytoriow * 150.0;
        return koszt;
    }

    @Override
    public String przedstawSie() {
        return "Programista: " + getImie() + " " + getNazwisko() +
                " [" + pobierzIdPracownika() + "]" +
                ", jezyk: " + glownyJezyk +
                ", repozytoria: " + liczbaRepozytoriow;
    }

    public void wypiszTechnologie() {
        System.out.println("Technologie programisty " + getImie() + " " + getNazwisko() + ":");
        System.out.println("  Glowny jezyk: " + glownyJezyk);
        System.out.println("  Liczba repozytoriow: " + liczbaRepozytoriow);
    }

    public String getGlownyJezyk() { return glownyJezyk; }
    public int getLiczbaRepozytoriow() { return liczbaRepozytoriow; }
}
