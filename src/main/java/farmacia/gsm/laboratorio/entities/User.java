package farmacia.gsm.laboratorio.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import farmacia.gsm.laboratorio.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @JsonIgnore
    @NotNull
    private String password;

    @JsonIgnore
    @NotNull
    private Role role;
}
