package vladislav.tetsoshivili.shop.service;

import vladislav.tetsoshivili.shop.model.Cart;
import vladislav.tetsoshivili.shop.model.Order;

public class SimpleOrderService implements OrderService {
    @Override
    public Order createOrder(Cart cart) {
        if (cart.getItems().isEmpty()) {
            // Учел сценарий, когда ничего не добавили в корзину
            throw new IllegalStateException("В корзине ничего нет, для оформеления добавьте товар");
        }
        return new Order(cart.getItems(), cart.getTotalPrice());
    }
}
