package com.gzarzur.generationblog.rest.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ThemeRequest {

    @Length(min = 3, max = 50, message = "The field 'description' must be between 3 and 50 characters.")
    @NotBlank(message = "The field 'description' is required.")
    private String description;

}
