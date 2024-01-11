package com.vaibhav2903.orderservice.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLineItemsDto {


    private long Id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
