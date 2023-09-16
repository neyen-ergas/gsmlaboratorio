package farmacia.gsm.laboratorio.dto;

import farmacia.gsm.laboratorio.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtAuthResponse {
    String token;
//    String refreshToken;
    User user;
}