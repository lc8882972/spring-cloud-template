package com.yan.auth.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equalsIgnoreCase(username)) {

            User user = mockUser();

            return user;

        }
        return null;
    }

    private User mockUser() {

        Collection<GrantedAuthority> authorities = new HashSet<>();
        //用户所拥有的角色信息
        authorities.add(new SimpleGrantedAuthority("admin"));

        User user = new User("admin", "123456", authorities);

        return user;

    }
}
