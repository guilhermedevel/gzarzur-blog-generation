package com.gzarzur.generationblog.rest.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
public class UserRequest {

    @Length(min = 3, max = 50, message = "The field 'name' must be between 3 and 50 characters.")
    @NotBlank(message = "The field 'name' is required.")
    private String name;

    @NotBlank(message = "The field 'email' is required.")
    @Pattern(regexp = "^[a-z0-9!#$%&'*+=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$", message = "The 'email' field must be a valid email.")
    private String email;
    private String photo;

}
