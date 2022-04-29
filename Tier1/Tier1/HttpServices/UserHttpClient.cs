using Contracts;
using Entities.Models;

namespace HttpServices; 

public class UserHttpClient : IUserService {
    public Task CreateUserAsync(User user) {
        throw new NotImplementedException();
    }

    public async Task<User> GetUserAsync(string username) {
        throw new NotImplementedException();
        // The following code is for testing....
        // return new User() {
        //     Username = "Sachin",
        //     Password = "helloThere12",
        //     FirstName = "Sachin",
        //     LastName = "Baral",
        //     Role = "User"
        // };
    }
}