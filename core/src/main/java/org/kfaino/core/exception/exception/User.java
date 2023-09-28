package org.kfaino.core.exception.exception;

import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}