package com.example.oauth2.helper;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        try{
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                return Optional.ofNullable(((UserDetails) principal).getUsername());
            } else {
                return Optional.ofNullable(principal.toString());
            }
        }catch(Exception e){
            return Optional.of("anonymous");
        }
    }
}
