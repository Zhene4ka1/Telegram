package com.exam.telegrambot1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserEntity {
    private Long id;
    private String name;
    private String password;
    private Boolean role;
}
