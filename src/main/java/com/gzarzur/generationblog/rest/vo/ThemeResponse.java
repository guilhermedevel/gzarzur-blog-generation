package com.gzarzur.generationblog.rest.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThemeResponse {

    private Long id;
    private String description;

}
