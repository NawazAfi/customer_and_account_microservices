package com.userServices;


//
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/users")
//@AllArgsConstructor
//public class UserController {
//
//    private UserService userService;
//    
//    
//
//    public UserController(UserService userService) {
//		super();
//		this.userService = userService;
//	}
//
//	@PostMapping
//    public ResponseEntity<User> saveUser(@RequestBody User user){
//        User savedUser = userService.saveUser(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId){
//        ResponseDto responseDto = userService.getUser(userId);
//        return ResponseEntity.ok(responseDto);
//    }
//}





//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/users")
//@AllArgsConstructor
//public class UserController {
//
//    private UserService userService;
//
//    public UserController(UserService userService) {
//        super();
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<User> saveUser(@RequestBody User user) {
//        User savedUser = userService.saveUser(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId) {
//        ResponseDto responseDto = userService.getUser(userId);
//        return ResponseEntity.ok(responseDto);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
//        User updatedUser = userService.updateUserById(id, user);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
//        userService.deleteCustomerById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}




//New method to get all accounts

//
////
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId) {
        ResponseDto responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = userService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUserById(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
        userService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


