using System.Threading.Tasks;
using Application.DAOInterfaces;
using Entities.Models;

namespace EFC.DAOImpl;

public class MessageDAOImpl : IMessageDAO {

    private readonly DbAccess _db;

    public MessageDAOImpl(DbAccess _db) {
        this._db = _db;
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