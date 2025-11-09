package com.example.b4minorproject.dtos;

import com.example.b4minorproject.models.Admin;
import com.example.b4minorproject.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAdminRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    public Admin toAdmin(){
        return Admin.builder().user(User.builder().username(this.username).password(this.password).build()).name(this.name).build();
    }
}
