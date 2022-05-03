package group6.semester.project.controller;


import group6.semester.project.model.User;
import group6.semester.project.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    // Don't use autowired on the field.

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity addUser(@RequestBody User user) {
        try{
            System.out.println(user.getUsername());
            User addedUser = userService.CreateUserAsync(user);
            return ResponseEntity.ok().body(addedUser);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
   }


  @GetMapping(value = "/user/{username}")
  @ResponseBody
  public ResponseEntity getUser(@PathVariable String username){
    try {

      User userFromServer = userService.GetUserAsync(username);
      return ResponseEntity.ok(userFromServer);
    } catch (Exception e) {
        System.out.println(e.getMessage());
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
