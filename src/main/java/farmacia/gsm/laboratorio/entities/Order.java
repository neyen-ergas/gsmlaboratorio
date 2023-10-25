package farmacia.gsm.laboratorio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import farmacia.gsm.laboratorio.enums.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @ManyToOne
    @NotNull
    private Formula formula;

    @NotNull
    private Integer phone;

    @NotNull
    private String parcialPay;

    @NotNull
    private String price;


    @OneToMany(fetch = FetchType.EAGER)
    private List<ImgRecipe> imgRecipe;

    @NotNull
    private String employee;

    @NotNull
    private State state;

    private String comment;

}
