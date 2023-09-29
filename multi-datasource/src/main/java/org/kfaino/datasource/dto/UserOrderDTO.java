package org.kfaino.datasource.dto;

import lombok.Data;

@Data
public class UserOrderDTO {

    private String name;

    private String email;
    private String orderNumber;

    private Double amount;
}
