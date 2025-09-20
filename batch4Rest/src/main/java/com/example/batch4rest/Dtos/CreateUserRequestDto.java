package com.example.batch4rest.Dtos;

import com.example.batch4rest.Models.Gender;
import com.example.batch4rest.Models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
//import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

public class CreateUserRequestDto {

    @NotBlank
    private  String name;

    @Email
//    @UniqueElements

    private  String email;

//    @NotBlank
//    @
    @NotNull
    private Integer age;

    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User toModel(){
        User user = new User();
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setGender(this.getGender());
        user.setAge(this.getAge());
        user.setCreatedOn(new Date());
        user.setUpdatedON(new Date());
        return user;
    }
}
