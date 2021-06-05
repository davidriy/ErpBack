package riy.david.erp.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import riy.david.erp.model.User;
import riy.david.erp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }
    public ResponseEntity<Optional<User>> getUserByUsername(User user){
        return ResponseEntity.ok(userRepository.findByUsername(user.getUsername()));
    }
}
