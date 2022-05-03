using System;
using System.Threading.Tasks;
using Entities.Models;

namespace Entities.Contracts;

public interface IUserService
{
    Task<User?> AddUser (User user);
    Task<User?> GetUser(String username);
}