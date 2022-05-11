package group6.semester.project.grpcClient.user;

import GRPCService.UserGrpc;
import GRPCService.UserOuterClass;
import group6.semester.project.grpcClient.ManagedChannelGetter;
import group6.semester.project.model.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.stereotype.Service;

@Service
public class GRPCUserClientImpl implements UserClient {
    private UserGrpc.UserBlockingStub userBlockingStub;


    /**
     * If the userBlockingStub is null, create a new ManagedChannel and a new userBlockingStub
     *
     * @return A blocking stub.
     */
    public UserGrpc.UserBlockingStub getUserBlockingStub() {
        if (userBlockingStub == null) {
            ManagedChannel managedChannel = ManagedChannelGetter.getManagedChannel();
            userBlockingStub = UserGrpc.newBlockingStub(managedChannel);
        }
        return userBlockingStub;
    }



    /**
     * It converts a Java object to a Protobuf object, sends it to the server, receives a Protobuf object from the server,
     * and converts it back to a Java object
     *
     * @param user The user object that we want to send to the server.
     * @return User object
     */
    @Override
    public User addUser(User user) {
        // Converting User to UserProtoObj and sending it
        UserOuterClass.UserObj userObj = UserOuterClass.UserObj.newBuilder().setFirstName(
                user.getFirstName()).setLastName(user.getLastName()).setPassword(
                user.getPassword()).setUsername(user.getUsername()).setRole(
                "User").build();
//        System.out.println(userObj.getLastName());

        UserOuterClass.UserObj userObjFromServer ;
        try {
            userObjFromServer = getUserBlockingStub().addUser(
                    userObj);
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
            throw new RuntimeException(e.getStatus().getDescription());
        } finally {
            userBlockingStub = null;
        }


        System.out.println(userObjFromServer.getFirstName());


        // Converting received user to java obj
        //   System.out.println(userObjFromServer.getFirstName());

        User realObj = getUser(userObjFromServer);
        System.out.println(realObj.getUsername());
        return realObj;
    }


    /**
     * It gets a user from the server.
     *
     * @param username The username of the user to be retrieved.
     * @return User object
     */
    @Override
    public User getUser(String username)  {
        // Sending username to get user from GRpc c#

        UserOuterClass.Username userNameProto = UserOuterClass.Username.newBuilder()
                .setUserName(username).build();
        UserOuterClass.UserObj userObjFromServer;
        try {
            userObjFromServer = getUserBlockingStub().getUser(userNameProto);

        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
            throw new RuntimeException(e.getStatus().getDescription());
        } finally {
            userBlockingStub = null;
        }


        // Converting received user to java obj

        return getUser(userObjFromServer);
    }

    //Converting user object that is sent from server ---
    /**
     * It takes a UserOuterClass.UserObj object and returns a User object
     *
     * @param userObjFromServer This is the object that is returned from the server.
     * @return A User object
     */
    private User getUser(UserOuterClass.UserObj userObjFromServer) {
        User returnedUser = new User();
        returnedUser.setFirstName(userObjFromServer.getFirstName());
        returnedUser.setLastName(userObjFromServer.getLastName());
        returnedUser.setUsername(userObjFromServer.getUsername());
        returnedUser.setPassword(userObjFromServer.getPassword());
        returnedUser.setRole(userObjFromServer.getRole());
        return returnedUser;
    }
}
