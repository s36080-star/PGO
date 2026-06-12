public abstract class MembershipPlan implements Billable {

    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    private static final double VAT_RATE = 0.23;

    public MembershipPlan(String planCode, String clientName, int months,
                          double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode()       { return planCode; }
    public String getClientName()     { return clientName; }
    public int getMonths()            { return months; }
    public double getBaseMonthlyFee() { return baseMonthlyFee; }
    public boolean isAutoRenew()      { return autoRenew; }

    public abstract String getPlanType();

    @Override
    public abstract double calculateMonthlyNetPrice();

    @Override
    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyNetPrice() * (1 + VAT_RATE);
    }

    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }

    public final void printSummary() {
        System.out.println("--- " + getPlanType() + " [" + planCode + "] ---");
        System.out.println("Client:         " + clientName);
        System.out.println("Months:         " + months);
        System.out.printf ("Monthly net:    %.2f%n", calculateMonthlyNetPrice());
        System.out.printf ("Monthly gross:  %.2f%n", calculateMonthlyGrossPrice());
        System.out.printf ("Total net:      %.2f%n", calculateTotalNetPrice());
    }

    @Override
    public String toString() {
        return getPlanType() + "{code='" + planCode + "'" +
                ", client='" + clientName + "'" +
                ", months=" + months +
                ", autoRenew=" + autoRenew +
                ", monthlyNet=" + String.format("%.2f", calculateMonthlyNetPrice()) + "}";
    }
}
