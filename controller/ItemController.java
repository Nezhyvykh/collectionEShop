import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String viewAllItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }

    @GetMapping("/item")
    public String viewItem(@RequestParam Long itemId, Model model) {
        model.addAttribute("item", itemService.getItemById(itemId));
        return "item";
    }

    @GetMapping("/search")
    public String searchItems(@RequestParam String keyword, Model model) {
        model.addAttribute("items", itemService.searchItems(keyword));
        return "items";
    }

    @GetMapping("/addItem")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAddItemForm() {
        return "add_item";
    }

    @PostMapping("/addItem")
    @PreAuthorize("hasRole('ADMIN')")
    public String addItem(@RequestParam String name, @RequestParam String description, @RequestParam double price, Model model) {
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        itemService.addItem(item);
        model.addAttribute("message", "Item added successfully.");
        return "add_item";
    }
}
