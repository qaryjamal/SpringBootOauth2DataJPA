package com.sd.campoc.service.user;

import com.sd.campoc.model.User;
import com.sd.campoc.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    public User findById(Long id, Boolean isActive, Boolean isDeleted) {
        return userRepository.findByIdAndContact_IsActiveAndContact_IsDeleted(id, isActive, isDeleted);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    public User findUserByUsernameAndRoleName(String userName, String roleName) {
        return userRepository.findByUserNameAndRole_Name(userName, roleName);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        saveUser(user);
    }

    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public User findByEmail(String email, Boolean isActive, Boolean isDeleted) {
        return userRepository.findByEmailAndContact_IsActiveAndContact_IsDeleted(email, isActive, isDeleted);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
