using Entities.Models;

namespace GrpcService.DAO;

public class UserDAOImpl : IUserDAO
{
    public Task<User> AddUser(User user)
    {
        Console.WriteLine(user.ToString());
        throw new NotImplementedException();
    }

    public async Task<User> GetUser(string username)
    {
        User user = new User()
        {
            FirstName = "Himal",
            LastName = "Sharma",
            Password = "123122",
            Role = "User",
            Username = "Himal"
        };

        return  user;
    }
}