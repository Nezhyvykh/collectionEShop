import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        User user = userService.getCurrentUser(); // метод для отримання поточного користувача
        model.addAttribute("items", user.getCart());
        return "cart";
    }

    @PostMapping("/checkout")
    public String checkout(Model model) {
        User user = userService.getCurrentUser();
        Order order = orderService.createOrder(user, user.getCart());
        user.getCart().clear(); // очистити кошик після замовлення
        model.addAttribute("order", order);
        return "order_confirmation";
    }
}
