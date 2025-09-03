package com.busra.springbootexercises.service;

import com.busra.springbootexercises.model.User;
import java.util.List;

public interface UserService {
    User create(User user);
    List<User> getAllUsers();
    User update(long id, User user);
    void delete(long id);
}
