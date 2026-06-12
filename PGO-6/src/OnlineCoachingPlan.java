public class OnlineCoachingPlan extends MembershipPlan implements RemoteAccess {

    private int videoConsultations;
    private boolean mealPlanIncluded;
    private boolean recordedLibraryAccess;

    public OnlineCoachingPlan(String planCode, String clientName, int months,
                              double baseMonthlyFee, boolean autoRenew,
                              int videoConsultations, boolean mealPlanIncluded,
                              boolean recordedLibraryAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.videoConsultations = videoConsultations;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;
    }

    @Override
    public String getPlanType() {
        return "OnlineCoachingPlan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = getBaseMonthlyFee();
        price += videoConsultations * 45.0;
        if (mealPlanIncluded) price += 60.0;
        if (recordedLibraryAccess) price += 20.0;
        if (isAutoRenew()) price -= 12.0;
        return price;
    }

    @Override
    public boolean hasOnlineAccess() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", videoConsultations=" + videoConsultations +
                ", mealPlan=" + mealPlanIncluded +
                ", library=" + recordedLibraryAccess + "}";
    }
}
