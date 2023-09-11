package farmacia.gsm.laboratorio.services.impl;

import farmacia.gsm.laboratorio.entities.User;
import farmacia.gsm.laboratorio.repositories.UserRepository;
import farmacia.gsm.laboratorio.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void softDeleteById(Long id) {
        var user = userRepository.findById(id);
        user.ifPresent(value -> {
            value.setSoftDelete(true);
            userRepository.save(value);
        });
    }

    public Optional<User> findById(Long Id) {
        return userRepository.findById(Id);
    }

    public User save(User user){return userRepository.save(user);}
}