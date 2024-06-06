import java.util.Date;
import java.util.List;

public class Order {
    private Long id;
    private User user;
    private List<Item> items;
    private Date orderDate;
    private String status;

    // Constructors, getters, and setters

    public Order() {}

    public Order(Long id, User user, List<Item> items, Date orderDate, String status) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
