public class Tester extends Pracownik {

    private boolean czyAutomatyzujacy;
    private int liczbaScenariuszy;

    public Tester(String idPracownika, String imie, String nazwisko,
                  double stawkaBazowa, boolean czyAutomatyzujacy, int liczbaScenariuszy) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.czyAutomatyzujacy = czyAutomatyzujacy;
        this.liczbaScenariuszy = liczbaScenariuszy;
    }

    @Override
    public double obliczKosztMiesieczny() {
        double koszt = getStawkaBazowa();
        if (czyAutomatyzujacy) {
            koszt += 800.0;
        }
        koszt += liczbaScenariuszy * 20.0;
        return koszt;
    }

    @Override
    public String przedstawSie() {
        return "Tester: " + getImie() + " " + getNazwisko() +
                " [" + pobierzIdPracownika() + "]" +
                ", automatyzacja: " + (czyAutomatyzujacy ? "tak" : "nie") +
                ", scenariusze: " + liczbaScenariuszy;
    }

    public void uruchomRaportTestow() {
        System.out.println("Raport testow dla " + getImie() + " " + getNazwisko() + ":");
        System.out.println("  Typ testow: " + (czyAutomatyzujacy ? "automatyczne" : "manualne"));
        System.out.println("  Liczba scenariuszy: " + liczbaScenariuszy);
    }

    public boolean isCzyAutomatyzujacy() { return czyAutomatyzujacy; }
    public int getLiczbaScenariuszy() { return liczbaScenariuszy; }
}
