package com.example.batch4rest.Dtos;

import com.example.batch4rest.Models.Gender;
import com.example.batch4rest.Models.User;

public class GetUserResponseDto {

    private Integer id;

    private  String name;

    private  String email;

    private Integer age;

    private Gender gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public static GetUserResponseDto fromModel(User user) {
        if(user == null){
            return null;
        }
        GetUserResponseDto getUserResponseDto = new GetUserResponseDto();
        getUserResponseDto.setId(user.getId());
        getUserResponseDto.setName(user.getName());
        getUserResponseDto.setEmail(user.getEmail());
        getUserResponseDto.setAge(user.getAge());
        getUserResponseDto.setGender(user.getGender());
        return getUserResponseDto;
    }
}
