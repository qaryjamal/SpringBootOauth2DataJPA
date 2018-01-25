package com.sd.campoc.service.user;


import com.sd.campoc.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User findById(Long id, Boolean isActive, Boolean isDeleted);

    User findByUserName(String userName);

    User findUserByUsernameAndRoleName(String userName, String roleName);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    void deleteAllUsers();

    User findByEmail(String email, Boolean isActive, Boolean isDeleted);

    List<User> findAllUsers();

}