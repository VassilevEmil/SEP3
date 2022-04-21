using GRPCService.DAO;
using Entities.Models;

namespace FileContext;

public class MessageDAOImpl : IMessageDAO {

    private JsonFileContext _jsonFileContext;

    public MessageDAOImpl(JsonFileContext jsonFileContext) {
        _jsonFileContext = jsonFileContext;
    }

    public async Task<Message> AddMessage(Message message) {
        _jsonFileContext.Messages.Add(message);
        await _jsonFileContext.SaveChangesAsync();
        return message;
    }

    public async Task<Message> GetMessage(int id) {
       return _jsonFileContext.Messages.First(message => message.Id == id);
    }
}