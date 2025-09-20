package com.example.batch4rest.Dtos;

import com.example.batch4rest.Models.User;

import java.util.Date;

public class CreateUserResponseDto {

    private Integer id;

    private Date createdOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public static CreateUserResponseDto fromModel(User user) {
        CreateUserResponseDto dto = new CreateUserResponseDto();
        dto.setId(user.getId());
        dto.setCreatedOn(user.getCreatedOn());
        return dto;
    }
}
