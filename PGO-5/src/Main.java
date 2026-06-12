public class Main {
    public static void main(String[] args) {
        ZespolProjektowy zespol = new ZespolProjektowy("Campus App");

        Pracownik p1 = new Programista("E-101", "Anna",  "Maj",    12000.0, "Java",   4);
        Pracownik p2 = new Tester     ("E-201", "Piotr", "Lis",     9800.0, true,    25);
        Pracownik p3 = new Programista("E-102", "Karol", "Wojcik", 11500.0, "Kotlin", 3);

        zespol.dodajPracownika(p1);
        zespol.dodajPracownika(p2);
        zespol.dodajPracownika(p3);

        zespol.wypiszSkladZespolu();
        System.out.printf("Laczny koszt zespolu: %.2f zl%n", zespol.policzLacznyKoszt());

        System.out.println();
        System.out.println(p1.przedstawSie());
        System.out.println(p2.przedstawSie());

        System.out.println();
        if (p1 instanceof Programista) {
            Programista programista = (Programista) p1;
            programista.wypiszTechnologie();
        }

        System.out.println();
        if (p2 instanceof Tester) {
            Tester tester = (Tester) p2;
            tester.uruchomRaportTestow();
        }

        System.out.println();
        zespol.wypiszTesterowAutomatyzujacych();

        System.out.println();
        System.out.println("Czy p2 rowna sie duplikatowi (ten sam id)? " +
                p2.equals(new Tester("E-201", "Inne", "Dane", 9000.0, false, 10)));
        System.out.println("Czy p1 rowna sie p2 (rozny id)?            " + p1.equals(p2));

        System.out.println();
        System.out.println(p2);

        System.out.println();
        Pracownik znaleziony = zespol.znajdzPoId("E-102");
        System.out.println("Znaleziono po id E-102: " + znaleziony);
    }
}
