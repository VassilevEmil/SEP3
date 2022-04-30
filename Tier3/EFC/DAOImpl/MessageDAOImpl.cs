using Application.DAOInterfaces;
using Entities.Models;

namespace EFC.DAOImpl;

public class MessageDAOImpl : IMessageDAO {

    private readonly DBContext _db;

    public MessageDAOImpl(DBContext _db) {
        _db = _db;
    }

    public async Task<Message> AddMessage(Message message)
    {
        return null;
    }

    public async Task<Message> GetMessage(int id)
    {
        return null;
    }
}