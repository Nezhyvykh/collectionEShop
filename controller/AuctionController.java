import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private BidService bidService;

    @GetMapping("/createAuction")
    @PreAuthorize("hasRole('ADMIN')")
    public String createAuctionPage() {
        return "create_auction";
    }

    @PostMapping("/createAuction")
    @PreAuthorize("hasRole('ADMIN')")
    public String createAuction(@RequestParam String itemName, @RequestParam double startingBid, Model model) {
        Auction auction = new Auction();
        auction.setItemName(itemName);
        auction.setStartingBid(startingBid);
        auctionService.createAuction(auction);
        model.addAttribute("message", "Auction created successfully.");
        return "create_auction";
    }

    @GetMapping("/auction")
    public String viewAuction(@RequestParam Long auctionId, Model model) {
        Auction auction = auctionService.getAuctionById(auctionId);
        model.addAttribute("auction", auction);
        model.addAttribute("bids", auction.getBids());
        return "auction";
    }

    @PostMapping("/bid")
    public String placeBid(@RequestParam Long auctionId, @RequestParam double bidAmount, Model model) {
        Auction auction = auctionService.getAuctionById(auctionId);
        if (bidService.placeBid(auction, bidAmount)) {
            model.addAttribute("message", "Bid placed successfully.");
        } else {
            model.addAttribute("error", "Bid amount must be higher than the current highest bid.");
        }
        model.addAttribute("auction", auction);
        model.addAttribute("bids", auction.getBids());
        return "auction";
    }
}
