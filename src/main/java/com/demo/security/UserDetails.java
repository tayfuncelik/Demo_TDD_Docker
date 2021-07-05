package com.demo.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Data
public class UserDetails {
    private Long id;
    private String userName;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    private List<String> roles;


    public void setAuth(List<String> roles) {
        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
        this.authorities = authorities;
    }


}
