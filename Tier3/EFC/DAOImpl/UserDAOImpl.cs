using System;
using System.Threading.Tasks;
using Application.DAOInterfaces;
using Entities.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EFC.DAOImpl;

public class UserDAOImpl : IUserDAO {
    private readonly DbAccess _context;

    public UserDAOImpl(DbAccess _context) {
        this._context = _context;
    }

    public async Task<User> AddUser(User user) {
        try {
            Console.Write(user.FirstName);
            EntityEntry<User> added = await _context.Users.AddAsync(user);
            await _context.SaveChangesAsync();
            return added.Entity;
        }
        catch (Exception e) {
            Console.WriteLine(e + " " + e.StackTrace); // or log to file, etc.
            throw; // re-throw the exception if you want it to continue up the stack
        }
    }

    public async Task<User?> GetUser(string username) {
        User? user = await _context.Users.FirstOrDefaultAsync(t => t.Username.Equals(username));
        if (user==null) {
            throw new Exception("Incorrect username");
        }
        return user;
    }
}