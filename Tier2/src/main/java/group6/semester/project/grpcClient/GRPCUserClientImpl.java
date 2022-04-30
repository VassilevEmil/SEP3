package group6.semester.project.grpcClient;

import GRPCService.UserGrpc;
import GRPCService.UserOuterClass;
import group6.semester.project.model.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCUserClientImpl implements  GRPCUserClient
{

  private UserGrpc.UserBlockingStub userBlockingStub;

  public GRPCUserClientImpl()
  {
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5250).usePlaintext().build();
    userBlockingStub = UserGrpc.newBlockingStub(managedChannel);
  }

  @Override public User addUser(User user)
  {

    // Converting User to UserProtoObj and sending it
    UserOuterClass.UserObj userObj = UserOuterClass.UserObj.newBuilder().setFirstName(
        user.getFirstName()).setLastName(user.getLastName()).setPassword(
        user.getPassword()).setUsername(user.getUsername()).setRole(
        user.getRole()).build();

    UserOuterClass.UserObj userObjFromServer = userBlockingStub.addUser(
        userObj);

    // Converting received user to java obj

    return getUser(userObjFromServer);
  }


  @Override public User getUser(String username)
  {
    // Sending username to get user from GRpc c#

    UserOuterClass.Username userNameProto = UserOuterClass.Username.newBuilder()
        .setUserName(username).build();
    UserOuterClass.UserObj userObjFromServer = userBlockingStub.getUser(userNameProto);

    // Converting received user to java obj

    return getUser(userObjFromServer);
  }

  //Converting user object that is sent from server ---
  private User getUser(UserOuterClass.UserObj userObjFromServer)
  {
    User returnedUser = new User();
    returnedUser.setFirstName(userObjFromServer.getFirstName());
    returnedUser.setLastName(userObjFromServer.getLastName());
    returnedUser.setUsername(userObjFromServer.getUsername());
    returnedUser.setPassword(userObjFromServer.getPassword());
    returnedUser.setRole(userObjFromServer.getRole());

    return returnedUser;
  }
}
