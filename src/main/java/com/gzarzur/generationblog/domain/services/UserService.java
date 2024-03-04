package com.gzarzur.generationblog.domain.services;

import com.gzarzur.generationblog.rest.vo.UserEditRequest;
import com.gzarzur.generationblog.rest.vo.UserRequest;
import com.gzarzur.generationblog.rest.vo.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    List<UserResponse> list();

    UserResponse findById(Long id);

    void delete(Long id);

    UserResponse edit(UserEditRequest userEditRequest, Long id);

}