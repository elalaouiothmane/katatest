package com.example.katatest.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static com.example.katatest.consts.Constants.MINIMUM_DELIVERY_DURATION;

@Document
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public DeliveryMode getDeliveryMode() {
        return deliveryMode;
    }

    public String getClientId() {
        return clientId;
    }

    public String getId() {
        return id;
    }

    @Id
    private String id;
    private String clientId;
    private DeliveryMode deliveryMode;
    private LocalDateTime deliveryDate;
    private LocalDateTime createdAt;
}
