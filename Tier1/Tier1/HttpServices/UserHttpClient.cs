using Contracts;
using Entities.Models;

namespace HttpServices; 

public class UserHttpClient : IUserService {
    public Task CreateUserAsync(User user) {
        throw new NotImplementedException();
    }

    public Task<User> GetUserAsync(string username) {
        throw new NotImplementedException();
    }
}