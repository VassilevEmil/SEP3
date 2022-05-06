using System;
using System.Threading.Tasks;
using Grpc.Core;
using Entities.Contracts;
using Entities.Models;

namespace GRPCService.ProtoImpl;

public class UserProtoImpl : User.UserBase {
    private IUserService _service;

    public UserProtoImpl(IUserService _service) {
        this._service = _service;
    }

    public override async Task<UserObj> AddUser(UserObj request, ServerCallContext context) {
        Console.WriteLine(request.Username);
        try {
            Entities.Models.User addingUser = new Entities.Models.User() {
                Username = request.Username,
                Password = request.Password,
                FirstName = request.FirstName,
                LastName = request.LastName,
                Role = request.Role
            };
            Entities.Models.User addedUser = await _service.AddUser(addingUser);

            UserObj userObj = new UserObj() {
                Username = addedUser.Username,
                Password = addedUser.Password,
                FirstName = addedUser.FirstName,
                LastName = addedUser.LastName,
                Role = addedUser.Role
            };

            return userObj;
        }
        catch (Exception e) {
            throw new RpcException(new Status(StatusCode.PermissionDenied, e.Message));
        }
    }


    public override Task<UserObj> GetUser(Username request, ServerCallContext context) {
        try {
            Entities.Models.User? userFromDatabase = _service.GetUser(request.UserName).Result;
            if (userFromDatabase == null) {
                throw new RpcException(new Status(StatusCode.NotFound, "Username not found"));
            }

            UserObj userToSend = new UserObj() {
                Username = userFromDatabase.Username,
                Password = userFromDatabase.Password,
                FirstName = userFromDatabase.FirstName,
                LastName = userFromDatabase.LastName,
                Role = userFromDatabase.Role
            };
            return Task.FromResult(userToSend);
        }             
        catch (Exception e) {
            Console.WriteLine(e.Message + "\n\n\n");
            throw new RpcException(new Status(StatusCode.NotFound, e.Message));
        }
    }
}