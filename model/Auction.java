import java.util.Date;

public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private double startingBid;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<Bid> bids;
    private Date startDate;
    private Date endDate;
    private Double startingBid;

    // Constructors, getters, and setters

    public Auction() {}

    public Auction( Date startDate, Date endDate, Double startingBid) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startingBid = startingBid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(Double startingBid) {
        this.startingBid = startingBid;
    }
}
