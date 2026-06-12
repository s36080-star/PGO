import java.util.ArrayList;

public class ZespolProjektowy {

    private String nazwaProjektu;
    private ArrayList<Pracownik> pracownicy;

    public ZespolProjektowy(String nazwaProjektu) {
        this.nazwaProjektu = nazwaProjektu;
        this.pracownicy = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public void wypiszSkladZespolu() {
        System.out.println("========================================");
        System.out.println("ZESPOL PROJEKTOWY: " + nazwaProjektu);
        System.out.println("Liczba czlonkow: " + pracownicy.size());
        System.out.println("========================================");
        for (Pracownik p : pracownicy) {
            System.out.println(p.przedstawSie());
            System.out.printf("  Koszt miesieczny: %.2f zl%n", p.obliczKosztMiesieczny());
        }
        System.out.println("========================================");
    }

    public double policzLacznyKoszt() {
        double suma = 0;
        for (Pracownik p : pracownicy) {
            suma += p.obliczKosztMiesieczny();
        }
        return suma;
    }

    public Pracownik znajdzPoId(String idPracownika) {
        for (Pracownik p : pracownicy) {
            if (p.pobierzIdPracownika().equals(idPracownika)) {
                return p;
            }
        }
        return null;
    }

    public void wypiszTesterowAutomatyzujacych() {
        System.out.println("Testerzy automatyzujacy w projekcie " + nazwaProjektu + ":");
        for (Pracownik p : pracownicy) {
            if (p instanceof Tester) {
                Tester t = (Tester) p;
                if (t.isCzyAutomatyzujacy()) {
                    System.out.println("  " + t.przedstawSie());
                }
            }
        }
    }
}
