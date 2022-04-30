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


    private UserService userService;


   public UserController(UserService userService)
    {
     this.userService = userService;
     }

   @PostMapping(value = "/user")
    public ResponseEntity addUser(@RequestBody User user) throws Exception {
        try{
            User addedUser = userService.CreateUserAsync(user);
            return ResponseEntity.ok().body(addedUser);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
   }


  @GetMapping(value = "/user/{username}")
  @ResponseBody
  public ResponseEntity getMessage(@PathVariable String username){
    try {

      User userFromServer = userService.GetUserAsync(username);
      return ResponseEntity.ok(userFromServer);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
