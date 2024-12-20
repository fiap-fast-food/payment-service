package com.guilherme.fiapfood.api;

import com.guilherme.fiapfood.api.dto.order.OrderDTO;
import com.guilherme.fiapfood.api.response.PaymentResponseDTO;
import com.guilherme.fiapfood.business.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @Operation(
            summary = "Create Payment",
            description = "create payment in mercado pago")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping
    public PaymentResponseDTO createPayment(@RequestBody OrderDTO orderDTO) {
        return paymentService.processPayment(orderDTO);
    }
}
