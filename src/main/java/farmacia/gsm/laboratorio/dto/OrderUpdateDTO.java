package farmacia.gsm.laboratorio.dto;

import farmacia.gsm.laboratorio.enums.State;
import lombok.Data;

@Data
public class OrderUpdateDTO {
    private String firstName;

    private String lastName;

    private String formula;

    private Integer phone;

    private String parcialPay;

    private String price;

    private String imgRecipe;

    private String employee;

    private State state;

    private String comment;
}
