import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByNameContainingIgnoreCase(String keyword);
}
