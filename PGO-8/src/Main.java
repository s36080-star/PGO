public class Main {
    public static void main(String[] args) {

        // ── Zadanie 1: Walidacja uzytkownika ──────────────────────────
        System.out.println("=== Zadanie 1: Walidacja uzytkownika ===");

        UserValidator validator = new UserValidator();
        validator.addRule(form -> form.email().contains("@"));
        validator.addRule(form -> form.password().length() >= 8);
        validator.addRule(form -> form.age() >= 18);

        UserForm validForm   = new UserForm("anna@example.com", "bezpieczne123", 20);
        UserForm invalidForm = new UserForm("brakmalpy.com",    "short",         15);

        System.out.println("Formularz poprawny:    " + validator.isValid(validForm));
        System.out.println("Formularz niepoprawny: " + validator.isValid(invalidForm));

        // ── Zadanie 2: Kalkulator ceny uslugi ────────────────────────
        System.out.println("\n=== Zadanie 2: Kalkulator ceny uslugi ===");

        ServiceOrder order = new ServiceOrder("Firma Alfa", 10, 120.0);
        PriceCalculator calculator = new PriceCalculator();

        PriceStrategy standard = o -> o.hours() * o.hourRate();
        PriceStrategy discount = o -> o.hours() * o.hourRate() * 0.90;
        PriceStrategy weekend  = o -> o.hours() * o.hourRate() * 1.25;

        System.out.println("Cena standardowa: " + calculator.calculate(order, standard));
        System.out.println("Cena z rabatem:   " + calculator.calculate(order, discount));
        System.out.println("Cena weekendowa:  " + calculator.calculate(order, weekend));

        // ── Zadanie 3: Zamowienie w sklepie ──────────────────────────
        System.out.println("\n=== Zadanie 3: Zamowienie w sklepie ===");

        Order shopOrder = new Order("ORD-100", "Anna Kowalska");
        shopOrder.addItem(new Order.OrderItem("Klawiatura", 249.99, 1));
        shopOrder.addItem(new Order.OrderItem("Mysz",        99.99, 2));

        OrderSummary summary = new OrderSummary(
                shopOrder.getOrderNumber(),
                shopOrder.getCustomerName(),
                shopOrder.total()
        );
        System.out.println(summary);

        // ── Zadanie 4: Konto biblioteczne ────────────────────────────
        System.out.println("\n=== Zadanie 4: Konto biblioteczne ===");

        LibraryAccount account = new LibraryAccount("Jan Nowak", 3, 5);
        LibraryAccount.FineCalculator fineCalc = account.new FineCalculator();

        double fine = fineCalc.calculate();

        MessagePrinter printer = message -> System.out.println("[BIBLIOTEKA] " + message);
        printer.print("Czytelnik: " + account.getReaderName() + ", oplata: " + fine + " zl");
    }
}
