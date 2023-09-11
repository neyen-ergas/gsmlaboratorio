package farmacia.gsm.laboratorio.dto;

import farmacia.gsm.laboratorio.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreateRequestDTO {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Role role;
}
