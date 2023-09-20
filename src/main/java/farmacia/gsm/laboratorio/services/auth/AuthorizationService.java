package farmacia.gsm.laboratorio.services.auth;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizationService {
    UserDetailsService userDetailsService();
}
