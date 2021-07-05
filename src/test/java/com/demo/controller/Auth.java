package com.demo.controller;

import com.demo.controller.payload.UserVO;
import com.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class Auth {
    @Autowired
    private JwtUtil jwtUtil;

    protected String getJWT() {
        UserVO user = new UserVO();
        user.setRole("USER");
        user.setUserName("deneme");
        String jwt = jwtUtil.generate(user, "ACCESS");
        return jwt;
    }
}
