public class PersonalTrainingPlan extends MembershipPlan {

    private int sessionsPerMonth;
    private int trainerLevel;
    private boolean dietConsultationIncluded;

    public PersonalTrainingPlan(String planCode, String clientName, int months,
                                double baseMonthlyFee, boolean autoRenew,
                                int sessionsPerMonth, int trainerLevel,
                                boolean dietConsultationIncluded) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.sessionsPerMonth = sessionsPerMonth;
        this.trainerLevel = trainerLevel;
        this.dietConsultationIncluded = dietConsultationIncluded;
    }

    @Override
    public String getPlanType() {
        return "PersonalTrainingPlan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = getBaseMonthlyFee();
        price += sessionsPerMonth * 70.0;
        if (trainerLevel == 2) price += 90.0;
        if (trainerLevel == 3) price += 180.0;
        if (dietConsultationIncluded) price += 50.0;
        if (isAutoRenew()) price -= 15.0;
        return price;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", sessions=" + sessionsPerMonth +
                ", trainerLevel=" + trainerLevel +
                ", diet=" + dietConsultationIncluded + "}";
    }
}
