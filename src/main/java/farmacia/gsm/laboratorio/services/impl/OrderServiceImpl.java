package farmacia.gsm.laboratorio.services.impl;

import farmacia.gsm.laboratorio.entities.Order;
import farmacia.gsm.laboratorio.repositories.OrderRepository;
import farmacia.gsm.laboratorio.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order ){
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long Id){
        return orderRepository.findById(Id);
    }


}
