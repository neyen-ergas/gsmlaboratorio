package farmacia.gsm.laboratorio.services;

import farmacia.gsm.laboratorio.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order save(Order order);
    Optional<Order> findById(Long id);

    List<Order> getAllOrders();


}
