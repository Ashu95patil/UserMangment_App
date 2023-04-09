package com.Neosoft.dto;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserDto {

    private Long userId;

    @Size(min = 3,max = 20,message = "Name should in format!!")
    private String name;

    //We take userName as Email
    @Email(message = "Email id should be in format")
    private String email;


    @NotEmpty(message = "Password is invalid!!")
    private String password;

    @Column(name = "SALARY")
    private Double salary;

    private Date createAt;

    private Date updateAt;

    private boolean active;



}
