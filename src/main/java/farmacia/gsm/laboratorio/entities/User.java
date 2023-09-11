package farmacia.gsm.laboratorio.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import farmacia.gsm.laboratorio.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Where(clause = "soft_delete = false")
public class User implements Serializable, UserDetails {
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

    @JsonIgnore
    @NotNull
    private boolean softDelete;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @JsonIgnore
    @Override
    public @NotNull String getPassword() { return password; }

    @JsonIgnore
    @Override
    public String getUsername() { return username; }

    @Override
    public boolean isAccountNonExpired() { return false; }

    @Override
    public boolean isAccountNonLocked() { return false; }

    @Override
    public boolean isCredentialsNonExpired() { return false; }

    @Override
    public boolean isEnabled() { return false; }

}
