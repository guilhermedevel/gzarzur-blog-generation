package com.gzarzur.generationblog.rest.controllers;

import com.gzarzur.generationblog.rest.vo.ThemeRequest;
import com.gzarzur.generationblog.rest.vo.ThemeResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ThemeController {

    @PostMapping
    ResponseEntity<ThemeResponse> create(@RequestBody @Valid ThemeRequest themeRequest);

    @GetMapping
    ResponseEntity<List<ThemeResponse>> list();

    @GetMapping("/{id}")
    ResponseEntity<ThemeResponse> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<ThemeResponse> edit(@RequestBody @Valid ThemeRequest themeRequest    , @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

}
