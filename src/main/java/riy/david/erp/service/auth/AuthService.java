package riy.david.erp.service.auth;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import riy.david.erp.dto.AuthenticationResponse;
import riy.david.erp.dto.LoginRequest;
import riy.david.erp.dto.RegisterRequest;
import riy.david.erp.model.User;
import riy.david.erp.repository.UserRepository;
import riy.david.erp.security.JwtProvider;

import java.time.Instant;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
//    @Autowired FIXME:
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;



    // @Transactional FIXME: Transactional para no relacional?
    @Transactional
    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setEmail(registerRequest.getUsername());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreationTime(Instant.now());
        user.setEnabled(true);
        userRepository.save(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authentication = null;
        try{
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch(Exception e){
            System.out.println("Se ha producido un ERROR AL LOGARSE: " + e.getMessage());
            e.printStackTrace();
        }
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .username(loginRequest.getUsername())
                .build();
    }
}
