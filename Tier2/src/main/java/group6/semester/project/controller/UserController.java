package group6.semester.project.controller;


import group6.semester.project.model.User;

import group6.semester.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

   @PostMapping(value = "/user")
    public ResponseEntity addUser(@RequestBody User user) throws Exception {
        try{
            ResponseEntity message = userService.CreateUserAsync(user);
            return ResponseEntity.ok().body(message);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
   }

}
