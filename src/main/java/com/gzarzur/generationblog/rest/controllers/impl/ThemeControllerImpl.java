package com.gzarzur.generationblog.rest.controllers.impl;

import com.gzarzur.generationblog.domain.services.ThemeService;
import com.gzarzur.generationblog.rest.controllers.ThemeController;
import com.gzarzur.generationblog.rest.vo.ThemeRequest;
import com.gzarzur.generationblog.rest.vo.ThemeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeControllerImpl implements ThemeController {

    private final ThemeService themeService;

    public ThemeControllerImpl(ThemeService themeService) {
        this.themeService = themeService;
    }

    @Override
    public ResponseEntity<ThemeResponse> create(ThemeRequest themeRequest) {
        var themeResponse = this.themeService.create(themeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(themeResponse);
    }

    @Override
    public ResponseEntity<List<ThemeResponse>> list() {
        var themeResponseList = this.themeService.list();
        return ResponseEntity.ok(themeResponseList);
    }

    @Override
    public ResponseEntity<ThemeResponse> findById(Long id) {
        var themeResponse = this.themeService.findById(id);
        return ResponseEntity.ok(themeResponse);
    }

    @Override
    public ResponseEntity<ThemeResponse> edit(ThemeRequest themeRequest, Long id) {
        var themeResponse = this.themeService.edit(themeRequest, id);
        return ResponseEntity.ok(themeResponse);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.themeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
