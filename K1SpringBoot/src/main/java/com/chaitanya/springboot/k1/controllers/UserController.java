package com.chaitanya.springboot.k1.controllers;

import com.chaitanya.springboot.k1.payloads.ApiResponse;
import com.chaitanya.springboot.k1.payloads.UserDto;
import com.chaitanya.springboot.k1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto =  this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
        UserDto updatedUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
//        return ResponseEntity.ok(Map.of("message","User Deleted Successfully"));
        return new ResponseEntity(Map.of("message","User Deleted Successfully"), HttpStatus.OK);
    }

//    @DeleteMapping("/{userId}")
//    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
//        this.userService.deleteUser(userId);
//        return ResponseEntity.ok(Map.of("message","User Deleted Successfully"));
//        return new ResponseEntity(new ApiResponse("Message",true), HttpStatus.OK);
//    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
