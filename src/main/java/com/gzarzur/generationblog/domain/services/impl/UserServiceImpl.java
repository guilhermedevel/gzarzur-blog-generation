package com.gzarzur.generationblog.domain.services.impl;

import com.gzarzur.generationblog.domain.exceptions.ObjectNotFoundException;
import com.gzarzur.generationblog.domain.exceptions.RuleViolationException;
import com.gzarzur.generationblog.domain.repository.UserRepository;
import com.gzarzur.generationblog.domain.services.UserService;
import com.gzarzur.generationblog.rest.vo.UserEditRequest;
import com.gzarzur.generationblog.rest.vo.UserRequest;
import com.gzarzur.generationblog.rest.vo.UserResponse;
import com.gzarzur.generationblog.domain.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse create(UserRequest userRequest) {

        if(!ObjectUtils.isEmpty(this.userRepository.findByEmail(userRequest.getEmail()))) {
            throw new RuleViolationException(String.format("The email '%s' is already registered.", userRequest.getEmail()));
        }

        var user = this.modelMapper.map(userRequest, User.class);

        var userSaved = this.userRepository.save(user);

        return this.modelMapper.map(userSaved, UserResponse.class);
    }

    @Override
    public List<UserResponse> list() {
        var users = this.userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();
    }

    @Override
    public UserResponse findById(Long id) {
        var user = this.getById(id);
        return this.modelMapper.map(user, UserResponse.class);
    }

    @Override
    public void delete(Long id) {
        var user = this.getById(id);
        this.userRepository.delete(user);
    }

    @Override
    public UserResponse edit(UserEditRequest userEditRequest, Long id) {
        var user = this.getById(id);
        this.validateUpdateEmail(userEditRequest, user);
        this.setEmptyFields(userEditRequest, user);
        this.modelMapper.map(userEditRequest, user);
        var userSaved = this.userRepository.save(user);
        return this.modelMapper.map(userSaved, UserResponse.class);
    }

    private User getById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found!"));
    }

    private void validateUpdateEmail(UserEditRequest userEditRequest, User user) {
        if(ObjectUtils.isEmpty(userEditRequest.getEmail())){
            userEditRequest.setEmail(user.getEmail());
        }

        if(!userEditRequest.getEmail().equals(user.getEmail()) && this.userExists(userEditRequest.getEmail())) {
            throw new RuleViolationException(String.format("The email '%s' is already registered.", userEditRequest.getEmail()));
        }
    }

    private boolean userExists(String email) {
        var user = this.userRepository.findByEmail(email).orElse(null);
        return !ObjectUtils.isEmpty(user);
    }

    private void setEmptyFields(UserEditRequest userEditRequest, User user) {
        if(ObjectUtils.isEmpty(userEditRequest.getName())){
            userEditRequest.setName(user.getName());
        }

        if(ObjectUtils.isEmpty(userEditRequest.getPhoto())){
            userEditRequest.setPhoto(user.getPhoto());
        }
    }
}
