package group6.semester.project.logic.SericeImpl;

import group6.semester.project.grpcClient.UserClient;
import group6.semester.project.grpcClient.GRPCUserClientImpl;
import group6.semester.project.model.User;
import group6.semester.project.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserClient client;

    public UserServiceImpl() {
        client = new GRPCUserClientImpl();
    }

    @Override
    public User CreateUserAsync(User user) {
        if (user.getFirstName()==null || user.getFirstName().isEmpty()) {
            throw new RuntimeException("Firstname cannot be empty");
        }
        if (user.getLastName()==null || user.getLastName().isEmpty()) {
            throw new RuntimeException("Lastname cannot be empty");
        }
        validateUsername(user.getUsername());
        validatePassword(user.getPassword());
        return client.addUser(user);
    }

    private void validatePassword(String password) {
        if (password==null|| password.isEmpty()) {
            throw new RuntimeException("Password cannot be empty");
        }
        if (password.length() < 6) {
            throw new RuntimeException("Password must be at least six characters");
        }
        boolean capitalLetter = false;
        boolean digitLetter = false;

        for (Character c : password.toCharArray()
        ) {
            if (!capitalLetter){
                if (Character.isUpperCase(c)){
                    capitalLetter =true;
                }
            }

            if (!digitLetter){
                if (Character.isDigit(c)){
                    digitLetter=true;
                }
            }
        }
        if (!capitalLetter){
            throw new RuntimeException("Password needs to contain at least one uppercase letter");
        }
        if (!digitLetter){
            throw new RuntimeException("Password needs to contain at least one digit letter");
        }
    }

    private void validateUsername(String username) {
        if (username==null ||  username.isEmpty()) {
            throw new RuntimeException("Username cannot be empty");
        }
        if (username.length() <= 6) {
            throw new RuntimeException("Username must be bigger than six characters");
        }
        if (username.length() >= 15) {
            throw new RuntimeException("Username must be smaller than fifteen characters");
        }
    }

    @Override
    public User GetUserAsync(String username) {
        validateUsername(username);
        return client.getUser(username);
        

    }
}
