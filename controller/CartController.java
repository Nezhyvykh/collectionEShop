import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cartService.getCartForCurrentUser());
        return "cart";
    }

    @PostMapping("/addToCart")
    public String addItemToCart(@RequestParam Long itemId, Model model) {
        cartService.addItemToCart(itemId);
        model.addAttribute("message", "Item added to cart.");
        return "redirect:/cart";
    }
}
