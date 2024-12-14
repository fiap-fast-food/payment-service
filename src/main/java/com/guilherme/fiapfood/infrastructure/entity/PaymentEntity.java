package com.guilherme.fiapfood.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "payment_entity")
public class PaymentEntity {

    @Id
    private String id;
    private Long orderId;
    private List<String> productIds;
    private String clientId;
    private String initPoint;
    private Long collectorId;
    private LocalDateTime dateCreated;

}
