package farmacia.gsm.laboratorio.services.impl;

import farmacia.gsm.laboratorio.entities.Order;
import farmacia.gsm.laboratorio.repositories.OrderRepository;
import farmacia.gsm.laboratorio.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public Order save(Order order ){
        return orderRepository.save(order);
    }
}
