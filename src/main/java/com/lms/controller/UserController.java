package com.lms.controller;

import com.lms.dto.LoanDTO;
import com.lms.dto.UserDTO;
import com.lms.entity.User;
import com.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDTO> userGetById(@PathVariable int id){
        Optional<User> user1 = Optional.ofNullable(userService.getUser(id));
        if(user1.isPresent()){

            User user = user1.get();

            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());

            LoanDTO loanDTO = new LoanDTO();
            loanDTO.setId(user.getLoan().getId());
            loanDTO.setName(user.getLoan().getName());
            loanDTO.setAmount(user.getLoan().getAmount());

            userDTO.setLoan(loanDTO);

            return ResponseEntity.status(HttpStatus.OK).body(userDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> listOfUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listOfUser());
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));

//        Optional<User> user1 = Optional.ofNullable(userService.saveUser(user2));
//
//        if(user1.isPresent()){
//
//            User user = user1.get();
//
//            UserDTO userDTO = new UserDTO();
//
//            userDTO.setId(user.getId());
//            userDTO.setName(user.getName());
//            userDTO.setEmail(user.getEmail());
//            userDTO.setPhone(user.getPhone());
//
//            LoanDTO loanDTO = new LoanDTO();
//            loanDTO.setId(user.getLoan().getId());
//            loanDTO.setName(user.getLoan().getName());
//            loanDTO.setAmount(user.getLoan().getAmount());
//
//            userDTO.setLoan(loanDTO);
//
//            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
//        }
//        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteGetById(@PathVariable int id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
