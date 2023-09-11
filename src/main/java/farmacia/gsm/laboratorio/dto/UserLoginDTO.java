package farmacia.gsm.laboratorio.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
public class UserLoginDTO {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
