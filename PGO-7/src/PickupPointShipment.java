public class PickupPointShipment extends ShipmentOrder {

    private String lockerSize;
    private boolean fragile;

    public PickupPointShipment(String orderNumber, String customerName, double distanceKm,
                               double baseFee, boolean insured,
                               String lockerSize, boolean fragile) {
        super(orderNumber, customerName, distanceKm, baseFee, insured);
        this.lockerSize = lockerSize;
        this.fragile = fragile;
    }

    @Override
    public String getShipmentType() {
        return "Pickup point";
    }

    @Override
    protected void validateSpecificRules() {
        if (!lockerSize.equals("S") && !lockerSize.equals("M") && !lockerSize.equals("L")) {
            throw new IllegalArgumentException("Invalid locker size: " + lockerSize);
        }
    }

    @Override
    protected double calculateBasePrice() {
        return getBaseFee() + getDistanceKm() * 0.75;
    }

    @Override
    protected double calculateAdditionalFee() {
        double fee = 0;
        switch (lockerSize) {
            case "S": fee += 5.0;  break;
            case "M": fee += 10.0; break;
            case "L": fee += 18.0; break;
        }
        if (fragile) fee += 12.0;
        return fee;
    }
}
