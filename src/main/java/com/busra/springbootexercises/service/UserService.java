package com.busra.springbootexercises.service;

import com.busra.springbootexercises.dto.request.UserRequest;
import com.busra.springbootexercises.dto.response.UserResponse;
import com.busra.springbootexercises.model.User;
import com.busra.springbootexercises.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse create(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setMessage("Kullanıcı oluşturuldu");
        return userResponse;
    }

    public List<UserResponse> findAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for(User user : users){
            UserResponse userResponse = new UserResponse();
            userResponse.setMessage("Kullanıcı Bilgileri: " + user.getUsername() + " | " + user.getEmail());
            userResponseList.add(userResponse);
        }
        return userResponseList;
    }
}
