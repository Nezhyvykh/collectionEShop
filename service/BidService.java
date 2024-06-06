import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private UserService userService;

    public boolean placeBid(Auction auction, double bidAmount) {
        double highestBid = auction.getBids().stream().mapToDouble(Bid::getAmount).max().orElse(auction.getStartingBid());
        if (bidAmount > highestBid) {
            Bid bid = new Bid();
            bid.setAmount(bidAmount);
            bid.setAuction(auction);
            bid.setUser(userService.getCurrentUser());
            bidRepository.save(bid);
            auction.getBids().add(bid);
            return true;
        }
        return false;
    }
}
