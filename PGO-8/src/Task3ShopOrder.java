import java.util.ArrayList;
import java.util.List;

// Zadanie 3: Zamowienie w sklepie

record OrderSummary(String orderNumber, String customerName, double totalAmount) {}

class Order {
    private String orderNumber;
    private String customerName;
    private List<OrderItem> items = new ArrayList<>();

    public Order(String orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double total() {
        double sum = 0;
        for (OrderItem item : items) sum += item.total();
        return sum;
    }

    public String getOrderNumber() { return orderNumber; }
    public String getCustomerName() { return customerName; }

    public static class OrderItem {
        private String productName;
        private double unitPrice;
        private int quantity;

        public OrderItem(String productName, double unitPrice, int quantity) {
            this.productName = productName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public double total() {
            return unitPrice * quantity;
        }

        @Override
        public String toString() {
            return productName + " x" + quantity + " = " + total() + " zl";
        }
    }
}
