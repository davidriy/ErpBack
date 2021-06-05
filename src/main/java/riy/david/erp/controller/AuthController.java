package riy.david.erp.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import riy.david.erp.dto.AuthenticationResponse;
import riy.david.erp.dto.LoginRequest;
import riy.david.erp.dto.RegisterRequest;
import riy.david.erp.service.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>("User registration successful", HttpStatus.OK);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
       return authService.login(loginRequest);
    }
}
