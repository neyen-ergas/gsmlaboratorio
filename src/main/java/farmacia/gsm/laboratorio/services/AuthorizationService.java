package farmacia.gsm.laboratorio.services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizationService {
    UserDetailsService userDetailsService();
}
