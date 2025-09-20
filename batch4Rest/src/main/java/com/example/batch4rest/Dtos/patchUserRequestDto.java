package com.example.batch4rest.Dtos;

import com.example.batch4rest.Models.Gender;
import com.example.batch4rest.Models.User;

public class patchUserRequestDto {

    private  String name;

    private  String email;

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
        user.setName(this.name);
        user.setEmail(this.email);
        user.setAge(this.age);
        user.setGender(this.gender);
        return user;
    }
}
