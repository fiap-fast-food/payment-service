package com.guilherme.fiapfood.infrastructure.repository;

import com.guilherme.fiapfood.infrastructure.entity.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PaymentRepository extends MongoRepository<PaymentEntity, UUID> {
}
