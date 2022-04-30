using Grpc.Core;
using Entities.Contracts;

namespace GRPCService.ProtoImpl;

public class UserProtoImpl : User.UserBase
{
     private IUserService _service;

     public UserProtoImpl(IUserService _service)
     {
          this._service = _service;
     }

     public override async Task<UserObj> AddUser(UserObj request, ServerCallContext context)
     {
          Entities.Models.User addingUser = new Entities.Models.User()
          {
               Username = request.Username,
               Password = request.Password,
               FirstName = request.FirstName,
               LastName = request.LastName,
               Role = request.Role
          };
       Entities.Models.User addedUser =   await _service.AddUser(addingUser);

       UserObj userObj = new UserObj()
       {
            Username = addedUser.Username,
            Password = addedUser.Password,
            FirstName = addedUser.FirstName,
            LastName = addedUser.LastName,
            Role = addedUser.Role
       };

       return userObj;
     }


     public override async Task<UserObj> GetUser(Username request, ServerCallContext context)
     {
          Console.Write(request.UserName);
         Entities.Models.User userFromDatabase =   _service.GetUser(request.UserName).Result;
         UserObj userToSend = new UserObj()
         {
              Username = userFromDatabase.Username,
              Password = userFromDatabase.Password,
              FirstName = userFromDatabase.FirstName,
              LastName = userFromDatabase.LastName,
              Role = userFromDatabase.Role
         };
         return userToSend;

     }
}