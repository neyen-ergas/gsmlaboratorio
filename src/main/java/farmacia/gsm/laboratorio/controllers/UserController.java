package farmacia.gsm.laboratorio.controllers;

import farmacia.gsm.laboratorio.dto.UserCreateRequestDTO;
import farmacia.gsm.laboratorio.entities.User;
import farmacia.gsm.laboratorio.exceptions.ErrorCode;
import farmacia.gsm.laboratorio.exceptions.UserException;
import farmacia.gsm.laboratorio.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findById(id).orElseThrow(
                () -> new UserException("No existe el usuario " +
                        "indicado ", ErrorCode.USER_DOESNT_EXIST)
        );
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id ) {
        userService.softDeleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequestDTO userCreateRequestDto) {
        User newUser = User.builder()
                .username(userCreateRequestDto.getUsername())
                .password(passwordEncoder.encode(userCreateRequestDto.getPassword()))
                .role(userCreateRequestDto.getRole())
                .build();
        userService.save(newUser);
        return ResponseEntity.ok(newUser);
    }
}
