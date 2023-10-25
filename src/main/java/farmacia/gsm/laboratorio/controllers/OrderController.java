package farmacia.gsm.laboratorio.controllers;

import farmacia.gsm.laboratorio.dto.OrderDTO;
import farmacia.gsm.laboratorio.dto.OrderUpdateDTO;
import farmacia.gsm.laboratorio.entities.Formula;
import farmacia.gsm.laboratorio.entities.ImgRecipe;
import farmacia.gsm.laboratorio.entities.Order;
import farmacia.gsm.laboratorio.enums.State;
import farmacia.gsm.laboratorio.services.FormulaService;
import farmacia.gsm.laboratorio.services.ImgRecipeService;
import farmacia.gsm.laboratorio.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @SneakyThrows
    @PatchMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable ("id") Long id, @Valid @RequestBody OrderUpdateDTO orderDTO)
    {
        Order order = orderService.findById(id).orElseThrow();


        if (orderDTO.getFormula() != null && !orderDTO.getFormula().isEmpty()) {

            Formula formula = order.getFormula();
            formula.setFormula(orderDTO.getFormula());
            formulaService.save(formula);
            order.setFormula(formula);
        }


        if (orderDTO.getImgRecipe() != null && !orderDTO.getImgRecipe().isEmpty()) {
            List<ImgRecipe> listImgRecipe = order.getImgRecipe();
            if (!listImgRecipe.isEmpty()) {
                ImgRecipe imgRecipe = listImgRecipe.get(0);

                imgRecipe.setBase64(orderDTO.getImgRecipe());

                imgRecipeService.save(imgRecipe);
            } else {

                ImgRecipe imgRecipe = ImgRecipe.builder()
                        .base64(orderDTO.getImgRecipe())
                        .build();

                imgRecipeService.save(imgRecipe);

                listImgRecipe.add(imgRecipe);
            }

            order.setImgRecipe(listImgRecipe);
        }


        if (orderDTO.getFirstName() != null && !orderDTO.getFirstName().isEmpty()) {
            order.setFirstName(orderDTO.getFirstName());
        }
        if (orderDTO.getLastName() != null && !orderDTO.getLastName().isEmpty()) {
            order.setLastName(orderDTO.getLastName());
        }

        if (orderDTO.getPhone() != null) {
            order.setPhone(orderDTO.getPhone());
        }
        if (orderDTO.getParcialPay() != null && !orderDTO.getParcialPay().isEmpty()) {
            order.setParcialPay(orderDTO.getParcialPay());
        }
        if (orderDTO.getPrice() != null && !orderDTO.getPrice().isEmpty()) {
            order.setPrice(orderDTO.getPrice());
        }

        if (orderDTO.getEmployee() != null && !orderDTO.getEmployee().isEmpty()) {
            order.setEmployee(orderDTO.getEmployee());
        }
        if (orderDTO.getState() != null) {
            order.setState(orderDTO.getState());
        }
        if (orderDTO.getComment() != null && !orderDTO.getComment().isEmpty()) {
            order.setComment(orderDTO.getComment());
        }

        orderService.save(order);
        return ResponseEntity.ok(order);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<Order> orderDetails(@PathVariable("id") Long id) {
        Order order = orderService.findById(id).orElseThrow();
        return ResponseEntity.ok(order);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

}
