package com.ui.application.application.Controller;

import com.ui.application.application.Service.CustomUserDetailsService;
import com.ui.application.application.Service.TokenService;
import com.ui.application.application.dto.LoginRequest;
import com.ui.application.application.dto.RequestUser;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/user")
public class PublicUserController {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody RequestUser user) {
        boolean isCreated = userDetailsService.createUser(user);
        return new ResponseEntity<>(isCreated ? "Success" : "Failed", HttpStatus.CREATED);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> generateToken(@RequestBody LoginRequest request) {
        String token = tokenService.verify(request);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
