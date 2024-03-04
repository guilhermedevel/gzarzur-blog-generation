package com.gzarzur.generationblog.rest.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PostRequest {

    @Length(min = 3, max = 50, message = "The field 'title' must be between 3 and 50 characters.")
    @NotBlank(message = "The field 'title' is required.")
    private String title;

    @Length(min = 10, max = 255, message = "The field 'text' must be between 3 and 50 characters.")
    @NotBlank(message = "The field 'text' is required.")
    private String text;

    @NotNull(message = "The field 'user' is required.")
    private Long userId;

    @NotNull(message = "The field 'theme' is required.")
    private Long themeId;
}
