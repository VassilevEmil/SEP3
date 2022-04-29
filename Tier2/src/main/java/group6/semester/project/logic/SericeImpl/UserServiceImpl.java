package group6.semester.project.logic.SericeImpl;

import group6.semester.project.grpcClient.GRPCClient;
import group6.semester.project.grpcClient.GRPCClientImpl;
import group6.semester.project.model.User;
import group6.semester.project.services.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.ResponseEntity;

public class UserServiceImpl implements UserService
{
    private GRPCClient client;

    public UserServiceImpl(){
        client = new GRPCClientImpl();
    }

    @Override
    public ResponseEntity CreateUserAsync(User user) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("TODO need to implement the GRPC function and link with service");
        // TODO: return ResponseEntity.ok().body()   // in body will return the message that the user have been created
    }

    @Override
    public ResponseEntity<User> GetUserAsync(String username) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("TODO need to implement the GRPC function and link with service");
        // TODO: return ResponseEntity.ok().body()   // in body will return the User
    }
}
