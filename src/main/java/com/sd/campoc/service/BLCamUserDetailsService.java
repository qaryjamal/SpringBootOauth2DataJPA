package com.sd.campoc.service;

import com.sd.campoc.model.User;
import com.sd.campoc.repositories.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/*
 * @author    : irfan
 * @Date      : 12-May-17
 * @version   : ver. 1.0.0
 * 
 * ________________________________________________________________________________________________
 *
 *  Developer				Date		     Version		Operation		Description
 * ________________________________________________________________________________________________ 
 *	
 * 
 * ________________________________________________________________________________________________
 *
 * @Project   : BLCamPOC
 * @Package   : com.sd.campoc.service
 * @FileName  : ACPUserDetailsService
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

@Service
public class BLCamUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public BLCamUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserDetails getUserDetails() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameOrEmail(username, username);
        if (user == null) {
            throw new UsernameNotFoundException("user name " + username + " not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getGrantedAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole().getName();
            }
        });
        return authorities;
    }
}
