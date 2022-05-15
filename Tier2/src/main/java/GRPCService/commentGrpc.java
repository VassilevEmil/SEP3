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
    comments = "Source: comment.proto")
public final class commentGrpc {

  private commentGrpc() {}

  public static final String SERVICE_NAME = "comment.comment";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GRPCService.Comment.CommentObjAndInteger,
      GRPCService.Comment.CommentObj> getAddCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddComment",
      requestType = GRPCService.Comment.CommentObjAndInteger.class,
      responseType = GRPCService.Comment.CommentObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.Comment.CommentObjAndInteger,
      GRPCService.Comment.CommentObj> getAddCommentMethod() {
    io.grpc.MethodDescriptor<GRPCService.Comment.CommentObjAndInteger, GRPCService.Comment.CommentObj> getAddCommentMethod;
    if ((getAddCommentMethod = commentGrpc.getAddCommentMethod) == null) {
      synchronized (commentGrpc.class) {
        if ((getAddCommentMethod = commentGrpc.getAddCommentMethod) == null) {
          commentGrpc.getAddCommentMethod = getAddCommentMethod = 
              io.grpc.MethodDescriptor.<GRPCService.Comment.CommentObjAndInteger, GRPCService.Comment.CommentObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "comment.comment", "AddComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Comment.CommentObjAndInteger.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Comment.CommentObj.getDefaultInstance()))
                  .setSchemaDescriptor(new commentMethodDescriptorSupplier("AddComment"))
                  .build();
          }
        }
     }
     return getAddCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GRPCService.Comment.Integer,
      GRPCService.Comment.CommentObj> getDeleteCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteComment",
      requestType = GRPCService.Comment.Integer.class,
      responseType = GRPCService.Comment.CommentObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.Comment.Integer,
      GRPCService.Comment.CommentObj> getDeleteCommentMethod() {
    io.grpc.MethodDescriptor<GRPCService.Comment.Integer, GRPCService.Comment.CommentObj> getDeleteCommentMethod;
    if ((getDeleteCommentMethod = commentGrpc.getDeleteCommentMethod) == null) {
      synchronized (commentGrpc.class) {
        if ((getDeleteCommentMethod = commentGrpc.getDeleteCommentMethod) == null) {
          commentGrpc.getDeleteCommentMethod = getDeleteCommentMethod = 
              io.grpc.MethodDescriptor.<GRPCService.Comment.Integer, GRPCService.Comment.CommentObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "comment.comment", "DeleteComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Comment.Integer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Comment.CommentObj.getDefaultInstance()))
                  .setSchemaDescriptor(new commentMethodDescriptorSupplier("DeleteComment"))
                  .build();
          }
        }
     }
     return getDeleteCommentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static commentStub newStub(io.grpc.Channel channel) {
    return new commentStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static commentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new commentBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static commentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new commentFutureStub(channel);
  }

  /**
   */
  public static abstract class commentImplBase implements io.grpc.BindableService {

    /**
     */
    public void addComment(GRPCService.Comment.CommentObjAndInteger request,
        io.grpc.stub.StreamObserver<GRPCService.Comment.CommentObj> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCommentMethod(), responseObserver);
    }

    /**
     */
    public void deleteComment(GRPCService.Comment.Integer request,
        io.grpc.stub.StreamObserver<GRPCService.Comment.CommentObj> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCommentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddCommentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.Comment.CommentObjAndInteger,
                GRPCService.Comment.CommentObj>(
                  this, METHODID_ADD_COMMENT)))
          .addMethod(
            getDeleteCommentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.Comment.Integer,
                GRPCService.Comment.CommentObj>(
                  this, METHODID_DELETE_COMMENT)))
          .build();
    }
  }

  /**
   */
  public static final class commentStub extends io.grpc.stub.AbstractStub<commentStub> {
    private commentStub(io.grpc.Channel channel) {
      super(channel);
    }

    private commentStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected commentStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new commentStub(channel, callOptions);
    }

    /**
     */
    public void addComment(GRPCService.Comment.CommentObjAndInteger request,
        io.grpc.stub.StreamObserver<GRPCService.Comment.CommentObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteComment(GRPCService.Comment.Integer request,
        io.grpc.stub.StreamObserver<GRPCService.Comment.CommentObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCommentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class commentBlockingStub extends io.grpc.stub.AbstractStub<commentBlockingStub> {
    private commentBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private commentBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected commentBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new commentBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPCService.Comment.CommentObj addComment(GRPCService.Comment.CommentObjAndInteger request) {
      return blockingUnaryCall(
          getChannel(), getAddCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public GRPCService.Comment.CommentObj deleteComment(GRPCService.Comment.Integer request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCommentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class commentFutureStub extends io.grpc.stub.AbstractStub<commentFutureStub> {
    private commentFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private commentFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected commentFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new commentFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.Comment.CommentObj> addComment(
        GRPCService.Comment.CommentObjAndInteger request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.Comment.CommentObj> deleteComment(
        GRPCService.Comment.Integer request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCommentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_COMMENT = 0;
  private static final int METHODID_DELETE_COMMENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final commentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(commentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_COMMENT:
          serviceImpl.addComment((GRPCService.Comment.CommentObjAndInteger) request,
              (io.grpc.stub.StreamObserver<GRPCService.Comment.CommentObj>) responseObserver);
          break;
        case METHODID_DELETE_COMMENT:
          serviceImpl.deleteComment((GRPCService.Comment.Integer) request,
              (io.grpc.stub.StreamObserver<GRPCService.Comment.CommentObj>) responseObserver);
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

  private static abstract class commentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    commentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPCService.Comment.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("comment");
    }
  }

  private static final class commentFileDescriptorSupplier
      extends commentBaseDescriptorSupplier {
    commentFileDescriptorSupplier() {}
  }

  private static final class commentMethodDescriptorSupplier
      extends commentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    commentMethodDescriptorSupplier(String methodName) {
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
      synchronized (commentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new commentFileDescriptorSupplier())
              .addMethod(getAddCommentMethod())
              .addMethod(getDeleteCommentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
