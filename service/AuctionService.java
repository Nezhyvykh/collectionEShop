import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public Auction getAuctionById(Long id) {
        Optional<Auction> auction = auctionRepository.findById(id);
        return auction.orElse(null);
    }

    public Iterable<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }
}
