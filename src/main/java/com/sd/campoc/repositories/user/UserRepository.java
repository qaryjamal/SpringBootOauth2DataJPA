package com.sd.campoc.repositories.user;

import com.sd.campoc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByIdAndContact_IsActiveAndContact_IsDeleted(Long id, Boolean isActive, Boolean isDeleted);

    User findByUserName(String username);

    User findByUserNameAndRole_Name(String userName, String roleName);

    User findByUserNameOrEmail(String username, String email);

    User findByEmailAndContact_IsActiveAndContact_IsDeleted(String email, Boolean isActive, Boolean isDeleted);

}
