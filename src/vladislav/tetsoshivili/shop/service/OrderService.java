package vladislav.tetsoshivili.shop.service;

import vladislav.tetsoshivili.shop.model.Cart;
import vladislav.tetsoshivili.shop.model.Order;

public interface OrderService {
    Order createOrder(Cart cart);
}
