using Entities.Models;

namespace GrpcService.DAO;

public class UserDAOImpl : IUserDAO
{
    public Task<User> AddUser(User user)
    {
        Console.WriteLine(user.ToString());
        throw new NotImplementedException();
    }

    public Task<User> GetUser(string username)
    {
        Console.WriteLine(username.ToString());
        throw new NotImplementedException();
    }
}