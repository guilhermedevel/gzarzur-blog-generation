package com.gzarzur.generationblog.rest.controllers;

import com.gzarzur.generationblog.rest.vo.UserEditRequest;
import com.gzarzur.generationblog.rest.vo.UserRequest;
import com.gzarzur.generationblog.rest.vo.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {

    @PostMapping
    ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest userRequest);

    @GetMapping
    ResponseEntity<List<UserResponse>> list();

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<UserResponse> edit(@RequestBody @Valid UserEditRequest userEditRequest, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
