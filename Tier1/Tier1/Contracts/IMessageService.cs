using Entities.Models;

namespace Contracts; 

public interface IMessageService {
      Task<Message> SendMessageAsync(Message message);
      Task<Message> GetMessageByIdAsync(int id);
}