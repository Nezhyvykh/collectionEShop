import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    public Order placeOrder() {
        User user = userService.getCurrentUser();
        Cart cart = cartService.getCartForCurrentUser();
        List<Item> items = cart.getItems();

        if (items.isEmpty()) {
            return null;
        }

        Order order = new Order();
        order.setUser(user);
        order.setItems(items);
        order.setTotal(items.stream().mapToDouble(Item::getPrice).sum());
        order = orderRepository.save(order);

        cart.getItems().clear();
        cartRepository.save(cart);

        return order;
    }
}
