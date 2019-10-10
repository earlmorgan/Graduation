package com.bcdl.model.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserEntity {

    @NotNull
    @NotEmpty(message = "This cannot be null")
    @Size(min = 4, max = 6, message = "length is wrong")
    private String name;
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 10)
    private String password;

    public UserEntity() {
    }

    public UserEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
