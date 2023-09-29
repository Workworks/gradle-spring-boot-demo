package org.kfaino.datasource.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String orderNumber;

    private Double amount;
}
