package farmacia.gsm.laboratorio.controllers;

import farmacia.gsm.laboratorio.dto.JwtAuthResponse;
import farmacia.gsm.laboratorio.dto.UserLogInDTO;
import farmacia.gsm.laboratorio.services.auth.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @SneakyThrows
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> logIn(@Valid @RequestBody UserLogInDTO userDto) {
        return ResponseEntity.ok(authenticationService.logIn(userDto));
    }

}