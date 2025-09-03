package com.busra.springbootexercises.service.impl;

import com.busra.springbootexercises.model.User;
import com.busra.springbootexercises.repository.UserRepository;
import com.busra.springbootexercises.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User update(long id, User user) {
        if (userRepository.findById(id).isPresent()) {
            User updatedUser = userRepository.findById(id).get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhone(user.getPhone());
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
    }

    @Override
    public void delete(long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
    }


}
