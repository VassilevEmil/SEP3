using Application.DAOInterfaces;
using Entities.Models;

namespace EFC.DAOImpl;

public class UserDAOImpl : IUserDAO
{
    private readonly DBContext _context;

    public UserDAOImpl(DBContext _context)
    {
        this._context = _context;
    }
    
    public async Task<User> AddUser(User user)
    {
        Console.WriteLine(user.ToString());
        return null;
    }

    public async Task<User> GetUser(string username)
    {
        //TODO : user dao impl
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