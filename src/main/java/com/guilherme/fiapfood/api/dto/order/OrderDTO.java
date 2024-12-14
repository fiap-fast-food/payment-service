package com.guilherme.fiapfood.api.dto.order;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class OrderDTO {
    private Long idOrder;
    private List<ProductDTO> products;
    private CustomerDTO customer;

}
