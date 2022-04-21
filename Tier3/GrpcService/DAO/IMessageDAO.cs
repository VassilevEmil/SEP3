namespace GRPCService.DAO; 
using Entities.Models;

public interface IMessageDAO {
    Task<Message> AddMessage(Message message);
    Task<Message> GetMessage(int id);

}