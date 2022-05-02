using System;
using System.Threading.Tasks;
using Entities.Models;

namespace Application.DAOInterfaces; 

public interface IUserDAO
{
    Task<User> AddUser (User user);
    Task<User> GetUser(String username);
}