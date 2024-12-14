package com.guilherme.fiapfood.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.fiapfood.api.dto.order.OrderDTO;
import com.guilherme.fiapfood.business.PaymentService;
import com.guilherme.fiapfood.infrastructure.exceptions.Advisor;
import com.guilherme.fiapfood.utils.PaymentHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;
    private MockMvc mockMvc;

    AutoCloseable mock;

    @BeforeEach
    void setup() {
        mock = MockitoAnnotations.openMocks(this);
        PaymentController productController = new PaymentController(paymentService);
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .addFilter((request,response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                })
                .setControllerAdvice(new Advisor())
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class ProcessPayment {

        @Test
        void mustAllowProcessPayment() throws Exception {

            // Arrange
            var payment = PaymentHelper.gerarOrderDTO();
            when(paymentService.processPayment(payment)).thenReturn(PaymentHelper.gerarPaymentResponse());

            // Act && Assert
            mockMvc.perform(
                    post("/payment")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(payment))
            ).andExpect(status().isOk());

            verify(paymentService, times(1)).processPayment(any(OrderDTO.class));

        }
    }
    public static String asJsonString(final Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper.writeValueAsString(object);
    }

}