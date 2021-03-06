package com.demo.service.auth;

import com.demo.controller.payload.AuthRequest;
import com.demo.controller.payload.AuthResponse;
import com.demo.controller.payload.UserVO;
import com.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtUtil jwt;

    @Autowired
    public AuthService(final JwtUtil jwt) {
        this.jwt = jwt;
    }

    public AuthResponse register(AuthRequest authRequest) {
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));
        UserVO userVO = new UserVO();
        userVO.setPassword(authRequest.getPassword());
        userVO.setRole("USER");
        String accessToken = jwt.generate(userVO, "ACCESS");
        return new AuthResponse(accessToken);
    }
}
