package group6.semester.project.logic.SericeImpl;

import group6.semester.project.grpcClient.UserClient;
import group6.semester.project.grpcClient.GRPCUserClientImpl;
import group6.semester.project.model.User;
import group6.semester.project.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private UserClient client;

    public UserServiceImpl(){
        client = new GRPCUserClientImpl();
    }

    @Override
    public User CreateUserAsync(User user)  {
    return client.addUser(user);
    }

    @Override
    public User GetUserAsync(String username) {
            return client.getUser(username);

    }
}
