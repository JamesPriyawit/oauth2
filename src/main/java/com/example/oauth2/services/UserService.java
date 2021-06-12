package com.example.oauth2.services;

import com.example.oauth2.configs.ServerSecurityConfig;
import com.example.oauth2.dtos.UserDTO;
import com.example.oauth2.entities.user.User;
import com.example.oauth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DelegatingPasswordEncoder delegatingPasswordEncoder;
    @Autowired
    private ServerSecurityConfig serverSecurityConfig;

    public String createAndUpdate(
            UserDTO dto
    ){
        User user = dto.getId() != null ? userRepository.findOneById(dto.getId()) : new User();
        user.setUsername(dto.getUsername());
        user.setPassword(delegatingPasswordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setEnabled(true);
        user.setNonLocked(true);
        userRepository.saveAndFlush(user);
        return "success";
    }
}
