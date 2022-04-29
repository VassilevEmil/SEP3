using Entities.Models;

namespace Contracts; 

public interface IUserService {

    Task CreateUserAsync(User user);

    Task<User> GetUserAsync(string username);

    Task DeleteUser(string id);

    Task Update(User user);
    Task<User> GetUserById(string id);
    

}