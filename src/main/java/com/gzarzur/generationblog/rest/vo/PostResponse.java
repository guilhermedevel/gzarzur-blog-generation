package com.gzarzur.generationblog.rest.vo;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class PostResponse {

    private Long id;
    private String title;
    private String text;
    private OffsetDateTime date;

    private UserResponse user;
    private ThemeResponse theme;
}
