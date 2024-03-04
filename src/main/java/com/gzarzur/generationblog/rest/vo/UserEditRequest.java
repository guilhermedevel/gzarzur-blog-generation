package com.gzarzur.generationblog.rest.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserEditRequest {

    @Length(min = 3, max = 50, message = "The field 'name' must be between 3 and 50 characters.")
    private String name;

    @Pattern(regexp = "^[a-z0-9!#$%&'*+=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$", message = "The 'email' field must be a valid email.")
    private String email;
    private String photo;

}
