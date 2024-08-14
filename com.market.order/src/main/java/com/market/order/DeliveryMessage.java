package com.market.order;


import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryMessage {
    private UUID orderId;
    private UUID payment;

    private String userId;

    private Integer productId;
    private Integer productQuantity;

    private Integer payAmount;

    private String errorType;

}
