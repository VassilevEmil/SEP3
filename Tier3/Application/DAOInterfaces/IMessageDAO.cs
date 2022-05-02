using System.Threading.Tasks;
using Entities.Models;

namespace Application.DAOInterfaces; 
public interface IMessageDAO {
    Task<Message> AddMessage(Message message);
    Task<Message> GetMessage(int id);

}