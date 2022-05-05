/**
 * It's a service class that implements the UserService interface
 */
package group6.semester.project.services.SericeImpl;

import group6.semester.project.grpcClient.user.UserClient;
import group6.semester.project.model.User;
import group6.semester.project.services.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {
    private final UserClient client;

    public UserServiceImpl(UserClient userClient) {
      this.client = userClient;
    }

    //hasing passwords
    /**
     * `hashPassword` takes a plaintext password as a string and returns a hashed password as a string using a randomly
     * generated salt
     *
     * @param password_plaintext This is the plaintext password that you want to hash.
     * @return The hashed password.
     */
    protected static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(12);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }

    /**
     * `checkPassword` takes a plaintext password and a hash of the correct one for comparison, and returns whether or not
     * the plaintext password matches the correct hash
     *
     * @param password_plaintext This is the password that was provided by the user trying to log in during the login form
     * @param stored_hash The hash that was stored in the database.
     * @return A boolean value.
     */
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if(null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return(password_verified);
    }


    /**
     * > This function creates a user in the database
     *
     * @param user The user object that is being created.
     * @return The user object is being returned.
     */
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

        // Add Hashing password
        user.setPassword(hashPassword(user.getPassword()));

        return client.addUser(user);
    }
    /**
     * > The function takes a username as a parameter, validates it, and then returns the user object
     *
     * @param username The username of the user you want to retrieve.
     * @return A User object
     */
    @Override
    public User GetUserAsync(String username) {
        validateUsername(username);
        // todo do the decryption here....

        return client.getUser(username);
    }

    /**
     * It checks if the password is null or empty, if it's less than 6 characters, if it contains at least one uppercase
     * letter, and if it contains at least one digit
     *
     * @param password The password to validate.
     */
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


    /**
     * "If the username is null or empty, or if it's too short or too long, throw an exception."

     * @param username The username of the user.
     */
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


}
