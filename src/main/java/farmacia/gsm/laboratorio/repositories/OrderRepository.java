package farmacia.gsm.laboratorio.repositories;


import farmacia.gsm.laboratorio.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order save(Order order);
    Optional<Order> findById(Long id);


}
