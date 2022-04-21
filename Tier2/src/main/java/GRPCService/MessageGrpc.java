package GRPCService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: messageproto.proto")
public final class MessageGrpc {

  private MessageGrpc() {}

  public static final String SERVICE_NAME = "message.Message";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GRPCService.Messageproto.MessageObj,
      GRPCService.Messageproto.MessageObj> getAddMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddMessage",
      requestType = GRPCService.Messageproto.MessageObj.class,
      responseType = GRPCService.Messageproto.MessageObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.Messageproto.MessageObj,
      GRPCService.Messageproto.MessageObj> getAddMessageMethod() {
    io.grpc.MethodDescriptor<GRPCService.Messageproto.MessageObj, GRPCService.Messageproto.MessageObj> getAddMessageMethod;
    if ((getAddMessageMethod = MessageGrpc.getAddMessageMethod) == null) {
      synchronized (MessageGrpc.class) {
        if ((getAddMessageMethod = MessageGrpc.getAddMessageMethod) == null) {
          MessageGrpc.getAddMessageMethod = getAddMessageMethod = 
              io.grpc.MethodDescriptor.<GRPCService.Messageproto.MessageObj, GRPCService.Messageproto.MessageObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "message.Message", "AddMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Messageproto.MessageObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Messageproto.MessageObj.getDefaultInstance()))
                  .setSchemaDescriptor(new MessageMethodDescriptorSupplier("AddMessage"))
                  .build();
          }
        }
     }
     return getAddMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GRPCService.Messageproto.IdMessage,
      GRPCService.Messageproto.MessageObj> getGetMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessage",
      requestType = GRPCService.Messageproto.IdMessage.class,
      responseType = GRPCService.Messageproto.MessageObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.Messageproto.IdMessage,
      GRPCService.Messageproto.MessageObj> getGetMessageMethod() {
    io.grpc.MethodDescriptor<GRPCService.Messageproto.IdMessage, GRPCService.Messageproto.MessageObj> getGetMessageMethod;
    if ((getGetMessageMethod = MessageGrpc.getGetMessageMethod) == null) {
      synchronized (MessageGrpc.class) {
        if ((getGetMessageMethod = MessageGrpc.getGetMessageMethod) == null) {
          MessageGrpc.getGetMessageMethod = getGetMessageMethod = 
              io.grpc.MethodDescriptor.<GRPCService.Messageproto.IdMessage, GRPCService.Messageproto.MessageObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "message.Message", "GetMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Messageproto.IdMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Messageproto.MessageObj.getDefaultInstance()))
                  .setSchemaDescriptor(new MessageMethodDescriptorSupplier("GetMessage"))
                  .build();
          }
        }
     }
     return getGetMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageStub newStub(io.grpc.Channel channel) {
    return new MessageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessageFutureStub(channel);
  }

  /**
   */
  public static abstract class MessageImplBase implements io.grpc.BindableService {

    /**
     */
    public void addMessage(GRPCService.Messageproto.MessageObj request,
        io.grpc.stub.StreamObserver<GRPCService.Messageproto.MessageObj> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMessageMethod(), responseObserver);
    }

    /**
     */
    public void getMessage(GRPCService.Messageproto.IdMessage request,
        io.grpc.stub.StreamObserver<GRPCService.Messageproto.MessageObj> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.Messageproto.MessageObj,
                GRPCService.Messageproto.MessageObj>(
                  this, METHODID_ADD_MESSAGE)))
          .addMethod(
            getGetMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.Messageproto.IdMessage,
                GRPCService.Messageproto.MessageObj>(
                  this, METHODID_GET_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class MessageStub extends io.grpc.stub.AbstractStub<MessageStub> {
    private MessageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageStub(channel, callOptions);
    }

    /**
     */
    public void addMessage(GRPCService.Messageproto.MessageObj request,
        io.grpc.stub.StreamObserver<GRPCService.Messageproto.MessageObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMessage(GRPCService.Messageproto.IdMessage request,
        io.grpc.stub.StreamObserver<GRPCService.Messageproto.MessageObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessageBlockingStub extends io.grpc.stub.AbstractStub<MessageBlockingStub> {
    private MessageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPCService.Messageproto.MessageObj addMessage(GRPCService.Messageproto.MessageObj request) {
      return blockingUnaryCall(
          getChannel(), getAddMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public GRPCService.Messageproto.MessageObj getMessage(GRPCService.Messageproto.IdMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessageFutureStub extends io.grpc.stub.AbstractStub<MessageFutureStub> {
    private MessageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.Messageproto.MessageObj> addMessage(
        GRPCService.Messageproto.MessageObj request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.Messageproto.MessageObj> getMessage(
        GRPCService.Messageproto.IdMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_MESSAGE = 0;
  private static final int METHODID_GET_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_MESSAGE:
          serviceImpl.addMessage((GRPCService.Messageproto.MessageObj) request,
              (io.grpc.stub.StreamObserver<GRPCService.Messageproto.MessageObj>) responseObserver);
          break;
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((GRPCService.Messageproto.IdMessage) request,
              (io.grpc.stub.StreamObserver<GRPCService.Messageproto.MessageObj>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPCService.Messageproto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Message");
    }
  }

  private static final class MessageFileDescriptorSupplier
      extends MessageBaseDescriptorSupplier {
    MessageFileDescriptorSupplier() {}
  }

  private static final class MessageMethodDescriptorSupplier
      extends MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessageMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageFileDescriptorSupplier())
              .addMethod(getAddMessageMethod())
              .addMethod(getGetMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
