using System.Text.Json;
using Contracts;
using Entities.Models;

namespace HttpServices;

public class UserHttpClient : IUserService
{
    public async Task CreateUserAsync(User user)
    {
        try
        {
            string client = await ClientAPI.getContent(Methods.Post, "/user", user);
            User user1 = JsonSerializer.Deserialize<User>(client, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            })!;
            Console.Write(user1.Username);
        }
        catch (Exception e)
        {
            throw new Exception(e.Message + e.StackTrace);
        }
    }

    public async Task<User> GetUserAsync(string username)
    {
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

    public Task DeleteUser(string id)
    {
        throw new NotImplementedException();
    }

    public Task Update(User user)
    {
        throw new NotImplementedException();
    }

    public Task<User> GetUserById(string id)
    {
        throw new NotImplementedException();
    }
}