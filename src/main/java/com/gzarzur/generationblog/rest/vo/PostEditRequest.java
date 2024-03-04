package com.gzarzur.generationblog.rest.vo;

import com.gzarzur.generationblog.domain.models.Theme;
import com.gzarzur.generationblog.domain.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PostEditRequest {

    @Length(min = 3, max = 50, message = "The field 'title' must be between 3 and 50 characters.")
    private String title;

    @Length(min = 10, max = 255, message = "The field 'text' must be between 3 and 50 characters.")
    private String text;

    @NotBlank(message = "The field 'user' is required.")
    private User user;

    @NotBlank(message = "The field 'theme' is required.")
    private Theme theme;
}
