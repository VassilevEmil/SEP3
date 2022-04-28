using Entities.Models;

namespace Contracts; 

public interface IUserService {

    Task CreateUserAsync(User user);

    Task<User> GetUserAsync(string username);

}