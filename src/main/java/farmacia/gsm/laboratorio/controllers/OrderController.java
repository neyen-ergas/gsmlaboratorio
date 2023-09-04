package farmacia.gsm.laboratorio.controllers;

import farmacia.gsm.laboratorio.dto.OrderDTO;
import farmacia.gsm.laboratorio.entities.Formula;
import farmacia.gsm.laboratorio.entities.ImgRecipe;
import farmacia.gsm.laboratorio.entities.Order;
import farmacia.gsm.laboratorio.enums.State;
import farmacia.gsm.laboratorio.services.FormulaService;
import farmacia.gsm.laboratorio.services.ImgRecipeService;
import farmacia.gsm.laboratorio.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final FormulaService formulaService;
    private final ImgRecipeService imgRecipeService;

    @SneakyThrows
    @PostMapping("/crear")
    public ResponseEntity<Order> createClient(@RequestBody OrderDTO order) {
        Formula formula = Formula.builder().
        formula(order.getFormula()).build();

        ImgRecipe imgRecipe = ImgRecipe.builder().
                base64(order.getImgRecipe()).build();

        formulaService.save(formula);
        imgRecipeService.save(imgRecipe);

        Order orderSaved = Order.builder()
                .firstName(order.getFirstName())
                .lastName(order.getLastName())
                .formula(formula)
                .phone(order.getPhone())
                .parcialPay(order.getParcialPay())
                .price(order.getPrice())
                .imgRecipe(List.of(imgRecipe))
                .employee(order.getEmployee())
                .state(State.ESPERA)
                .comment(order.getComment())
                .build();

        orderService.save(orderSaved);

        return ResponseEntity.ok(orderSaved);
    }
}
