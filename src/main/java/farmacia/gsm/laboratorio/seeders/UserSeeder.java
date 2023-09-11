package farmacia.gsm.laboratorio.seeders;

import farmacia.gsm.laboratorio.entities.User;
import farmacia.gsm.laboratorio.enums.Role;
import farmacia.gsm.laboratorio.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSeeder {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    public void seedUsers() {
        if (userRepository.count() != 0) {
            return;
        }

        User veendedor = User.builder()
                .username("vendedor")
                .password(passwordEncoder.encode("vendedor123"))
                .role(Role.VENDEDOR)
                .build();

        User laboratorio = User.builder()
                .username("laboratorio")
                .password(passwordEncoder.encode("123laboratorio"))
                .role(Role.LABORATORIO)
                .build();

        userRepository.saveAll(List.of(veendedor, laboratorio));
    }

}