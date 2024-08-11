package com.app.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.Entities.UserEntity;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public UserDetails loadUserById(Long userId) {
    	UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
}
