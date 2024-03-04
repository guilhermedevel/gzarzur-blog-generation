package com.gzarzur.generationblog.domain.services;

import com.gzarzur.generationblog.rest.vo.ThemeRequest;
import com.gzarzur.generationblog.rest.vo.ThemeResponse;

import java.util.List;

public interface ThemeService {
    ThemeResponse create(ThemeRequest themeRequest);

    List<ThemeResponse> list();

    ThemeResponse findById(Long id);

    ThemeResponse edit(ThemeRequest themeRequest, Long id);

    void delete(Long id);
}