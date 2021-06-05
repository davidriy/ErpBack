package riy.david.erp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import riy.david.erp.model.Product;
import riy.david.erp.model.User;
import riy.david.erp.service.product.ProductService;
import riy.david.erp.service.user.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody User user){
        User matchUser = userService.getUserByUsername(user).getBody().get();
        return new ResponseEntity<Boolean>(user.getPassword().equals(matchUser.getPassword()), HttpStatus.OK);
    }
}
