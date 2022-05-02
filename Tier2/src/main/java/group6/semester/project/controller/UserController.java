package group6.semester.project.controller;


import group6.semester.project.model.User;

import group6.semester.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {


    // Dont use autowired on the field..

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity addUser(@RequestBody User user) {
        try{
            ResponseEntity addedUser = userService.CreateUserAsync(user);
            return ResponseEntity.ok().body(addedUser);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }


  @GetMapping(value = "/user/{username}")
  @ResponseBody
  public ResponseEntity getUser(@PathVariable String username){
    try {

      ResponseEntity<User> userFromServer = userService.GetUserAsync(username);
      return ResponseEntity.ok(userFromServer);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
