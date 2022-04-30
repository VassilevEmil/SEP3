using Application.DAOInterfaces;
using Entities.Contracts;
using Entities.Models;

namespace Application.ServiceImpl;

public class UserServiceImpl : IUserService
{
    private IUserDAO _dao;

    public UserServiceImpl(IUserDAO _dao)
    {
        this._dao = _dao;
    }
    
    public async Task<User> AddUser(User user)
    {
        return await _dao.AddUser(user);
    }

    public async Task<User> GetUser(string username)
    {
        return await _dao.GetUser(username);
    }
}