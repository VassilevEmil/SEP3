package group6.semester.project.logic.SericeImpl;

import group6.semester.project.grpcClient.GRPCClient;
import group6.semester.project.grpcClient.GRPCClientImpl;
import group6.semester.project.grpcClient.GRPCUserClient;
import group6.semester.project.grpcClient.GRPCUserClientImpl;
import group6.semester.project.model.User;
import group6.semester.project.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private GRPCUserClient client;

    public UserServiceImpl(){
        client = new GRPCUserClientImpl();
    }

    @Override
    public ResponseEntity CreateUserAsync(User user) throws Exception {
    return client.addUser(user);
    }

    @Override
    public ResponseEntity<User> GetUserAsync(String username) throws Exception {
            return client.getUser(username);

    }
}
