// Zadanie 2: Kalkulator ceny uslugi

record ServiceOrder(String clientName, int hours, double hourRate) {}

@FunctionalInterface
interface PriceStrategy {
    double calculate(ServiceOrder order);
}

class PriceCalculator {
    public double calculate(ServiceOrder order, PriceStrategy strategy) {
        return strategy.calculate(order);
    }
}
