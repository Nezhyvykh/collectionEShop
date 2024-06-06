import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserService userService;

    public Cart getCartForCurrentUser() {
        User user = userService.getCurrentUser();
        Optional<Cart> cartOptional = cartRepository.findByUser(user);
        if (cartOptional.isPresent()) {
            return cartOptional.get();
        } else {
            Cart cart = new Cart();
            cart.setUser(user);
            return cartRepository.save(cart);
        }
    }

    public void addItemToCart(Long itemId) {
        Cart cart = getCartForCurrentUser();
        Item item = itemRepository.findById(itemId).orElse(null);
        if (item != null) {
            cart.getItems().add(item);
            cartRepository.save(cart);
        }
    }
}
