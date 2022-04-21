package group6.semester.project.grpcClient;


import GRPCService.MessageGrpc;
import GRPCService.Messageproto;
import group6.semester.project.model.Message;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class GRPCClientImpl implements GRPCClient {


    private MessageGrpc.MessageBlockingStub messageproto;

    public GRPCClientImpl() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5206).usePlaintext().build();
        messageproto = MessageGrpc.newBlockingStub(managedChannel);

    }

    @Override
    public Message addMessage(Message message) {
        Messageproto.MessageObj messageObj = Messageproto.MessageObj.newBuilder().setId(message.getId()).setBody(message.getBody()).build();
        Messageproto.MessageObj messageObjFromServer = messageproto.addMessage(messageObj);
        Message message1 = new Message();
        message1.setId(messageObjFromServer.getId());
        message1.setBody(messageObjFromServer.getBody());
        return message1;
    }

    @Override
    public Message getMessage(int id) {
        Messageproto.IdMessage idMessage = Messageproto.IdMessage.newBuilder().setId(id).build();
        Messageproto.MessageObj messageObjFromServer = messageproto.getMessage(idMessage);
        Message message1 = new Message();
        message1.setId(messageObjFromServer.getId());
        message1.setBody(messageObjFromServer.getBody());
        return message1;
    }
}
