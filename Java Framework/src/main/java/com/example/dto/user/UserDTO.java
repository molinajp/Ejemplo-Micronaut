package com.example.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    long id;

    @NotBlank(message = "The user name is mandatory")
    private String userName;
    @NotBlank(message = "The firstname is mandatory")
    private String firstName;
    @NotBlank(message = "The lastname is mandatory")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "The password is mandatory")
    @NotEmpty(message = "The password cannot be empty")
    private String password;
    @NotBlank(message = "The phone number is mandatory")
    private String phone;
    private Integer userStatus;

}
