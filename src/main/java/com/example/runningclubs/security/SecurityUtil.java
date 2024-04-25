package com.example.runningclubs.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static String getSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication instanceof UsernamePasswordAuthenticationToken) {
//            String currentUsername = authentication.getName();
//            return currentUsername;
//        }
        String currentUsername = authentication.getName();
        return currentUsername;
    }
}
