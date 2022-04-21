using Grpc.Core;
using GRPCService.DAO;
namespace GRPCService.Services; 

public class MessageService : Message.MessageBase {

    private IMessageDAO messageDao;

    public MessageService(IMessageDAO messageDao) {
        this.messageDao = messageDao;
    }

    public async override Task<MessageObj> AddMessage(MessageObj request, ServerCallContext context) {
        Entities.Models.Message messageEntity = new Entities.Models.Message() {
            Body = request.Body,
            Id = request.Id
        };
        Entities.Models.Message messageFromServer = await messageDao.AddMessage(messageEntity);
        MessageObj messageObj = new MessageObj() {
            Id = messageFromServer.Id,
            Body = messageFromServer.Body
        };
        return messageObj;
    }

    public async override Task<MessageObj> GetMessage(IdMessage request, ServerCallContext context) {
        int id = request.Id;
        Entities.Models.Message messageFromServer= await messageDao.GetMessage(id);
        MessageObj messageObj = new MessageObj() {
            Id = messageFromServer.Id,
            Body = messageFromServer.Body
        };
        return messageObj;
    }
}