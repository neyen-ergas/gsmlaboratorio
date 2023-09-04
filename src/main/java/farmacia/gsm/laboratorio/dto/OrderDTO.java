package farmacia.gsm.laboratorio.dto;

import farmacia.gsm.laboratorio.enums.State;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class OrderDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;


    @NotNull
    private String formula;

    @NotNull
    private Integer phone;

    @NotNull
    private String parcialPay;

    @NotNull
    private String price;

    private String imgRecipe;

    @NotNull
    private String employee;

    @NotNull
    private State state;


    private String comment;
}
