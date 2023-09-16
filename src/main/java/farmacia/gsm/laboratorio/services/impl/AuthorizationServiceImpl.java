package farmacia.gsm.laboratorio.services.impl;

import farmacia.gsm.laboratorio.repositories.UserRepository;
import farmacia.gsm.laboratorio.services.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
    private final UserRepository userRepository;
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                var us = userRepository.findUserByUsername(username);
                if (us.isPresent()) {
                    return us.get();
                }
                else {
                    throw new UsernameNotFoundException("Usuario no encontrado: " + username);
                }
            }
        };
    }
}
