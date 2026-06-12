public abstract class ShipmentOrder implements SummaryPrintable {

    private String orderNumber;
    private String customerName;
    private double distanceKm;
    private double baseFee;
    private boolean insured;
    protected double lastCalculatedPrice;

    public ShipmentOrder(String orderNumber, String customerName, double distanceKm,
                         double baseFee, boolean insured) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.distanceKm = distanceKm;
        this.baseFee = baseFee;
        this.insured = insured;
        this.lastCalculatedPrice = 0.0;
    }

    public String getOrderNumber()   { return orderNumber; }
    public String getCustomerName()  { return customerName; }
    public double getDistanceKm()    { return distanceKm; }
    public double getBaseFee()       { return baseFee; }
    public boolean isInsured()       { return insured; }

    public final void processOrder() {
        validateOrder();
        validateSpecificRules();

        double price = calculateBasePrice();
        price += calculateAdditionalFee();
        price = applyInsurance(price);
        price = applyBusinessDiscount(price);

        lastCalculatedPrice = price;
        printProcessingResult();
    }

    private void validateOrder() {
        if (orderNumber == null || orderNumber.isEmpty()) {
            throw new IllegalArgumentException("Order number cannot be empty.");
        }
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0.");
        }
    }

    protected void validateSpecificRules() {
        // hook - pusta domyslna implementacja
    }

    private double applyInsurance(double price) {
        if (insured) {
            price *= 1.07;
        }
        return price;
    }

    protected double applyBusinessDiscount(double price) {
        return price;
    }

    private void printProcessingResult() {
        System.out.printf("Processed [%s] %s | type: %s | price: %.2f PLN%n",
                orderNumber, customerName, getShipmentType(), lastCalculatedPrice);
    }

    @Override
    public String buildSummaryLine() {
        return String.format("Summary: [%s] %s | %s | %.2f PLN",
                orderNumber, customerName, getShipmentType(), lastCalculatedPrice);
    }

    protected abstract double calculateBasePrice();
    protected abstract double calculateAdditionalFee();
    public abstract String getShipmentType();
}
