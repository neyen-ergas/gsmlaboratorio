package farmacia.gsm.laboratorio.services;

import farmacia.gsm.laboratorio.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    void softDeleteById(Long id);
    Optional<User> findById(Long id);
    User save(User user);
}