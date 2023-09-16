package farmacia.gsm.laboratorio.services.auth;

import farmacia.gsm.laboratorio.dto.JwtAuthResponse;
import farmacia.gsm.laboratorio.dto.UserLogInDTO;
import farmacia.gsm.laboratorio.exceptions.UserException;

public interface AuthenticationService {
    JwtAuthResponse logIn(UserLogInDTO userLogInDTO) throws UserException;
}
