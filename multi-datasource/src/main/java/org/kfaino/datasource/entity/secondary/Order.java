package org.kfaino.datasource.entity.secondary;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private Double amount;
}
