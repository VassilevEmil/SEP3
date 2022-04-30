
using User = Entities.Models.User;

namespace GrpcService.DAO;

public interface IUserDAO
{
    Task<User> AddUser (User user);
    Task<User> GetUser(String username);
}