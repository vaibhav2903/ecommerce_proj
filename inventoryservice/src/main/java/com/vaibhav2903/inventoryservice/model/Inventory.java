package com.vaibhav2903.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String skuCode;
    private Integer quantity;

}
