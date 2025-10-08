package vladislav.tetsoshivili.shop.model;

import java.util.List;

public class Order {
    private final List<Product> products;
    private final double totalPrice;

    public Order(List<Product> products, double totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Заказ оформлен! Сумма: " + String.format("%.2f", totalPrice) + " руб.";
    }
}
