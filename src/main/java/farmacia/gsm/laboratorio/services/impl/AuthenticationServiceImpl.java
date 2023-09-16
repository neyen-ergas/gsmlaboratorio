package farmacia.gsm.laboratorio.services.impl;

import farmacia.gsm.laboratorio.dto.UserLogInDTO;
import farmacia.gsm.laboratorio.exceptions.ErrorCode;
import farmacia.gsm.laboratorio.exceptions.UserException;
import farmacia.gsm.laboratorio.repositories.UserRepository;
import farmacia.gsm.laboratorio.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public JwtAuthResponse logIn(UserLogInDTO userLogInDTO) throws UserException {

        var user = userRepository.findUserByUsername(userLogInDTO.getUsername());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLogInDTO.getUsername(), userLogInDTO.getPassword()));
        } catch (BadCredentialsException e) {
            var message = (user.isEmpty()) ? "Usuario no encontrado" : "Credenciales incorrectas";
            var errorCode = (user.isEmpty()) ? ErrorCode.USER_DOESNT_EXIST : ErrorCode.BAD_CREDENTIALS;
            throw new UserException(message, errorCode);
        }

        return jwtService.generateToken(user.get());

    }
}