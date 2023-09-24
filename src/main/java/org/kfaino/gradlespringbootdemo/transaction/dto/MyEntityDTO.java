package org.kfaino.gradlespringbootdemo.transaction.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MyEntityDTO {
    @NotBlank(message = "Name cannot be blank")
    private String name;
}
