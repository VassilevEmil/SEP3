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
    comments = "Source: post.proto")
public final class PostGrpc {

  private PostGrpc() {}

  public static final String SERVICE_NAME = "post.Post";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GRPCService.PostOuterClass.PostObj,
      GRPCService.PostOuterClass.PostObj> getAddPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPost",
      requestType = GRPCService.PostOuterClass.PostObj.class,
      responseType = GRPCService.PostOuterClass.PostObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.PostOuterClass.PostObj,
      GRPCService.PostOuterClass.PostObj> getAddPostMethod() {
    io.grpc.MethodDescriptor<GRPCService.PostOuterClass.PostObj, GRPCService.PostOuterClass.PostObj> getAddPostMethod;
    if ((getAddPostMethod = PostGrpc.getAddPostMethod) == null) {
      synchronized (PostGrpc.class) {
        if ((getAddPostMethod = PostGrpc.getAddPostMethod) == null) {
          PostGrpc.getAddPostMethod = getAddPostMethod = 
              io.grpc.MethodDescriptor.<GRPCService.PostOuterClass.PostObj, GRPCService.PostOuterClass.PostObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "post.Post", "AddPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.PostObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.PostObj.getDefaultInstance()))
                  .setSchemaDescriptor(new PostMethodDescriptorSupplier("AddPost"))
                  .build();
          }
        }
     }
     return getAddPostMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PostStub newStub(io.grpc.Channel channel) {
    return new PostStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PostBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PostBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PostFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PostFutureStub(channel);
  }

  /**
   */
  public static abstract class PostImplBase implements io.grpc.BindableService {

    /**
     */
    public void addPost(GRPCService.PostOuterClass.PostObj request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.PostObj> responseObserver) {
      asyncUnimplementedUnaryCall(getAddPostMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddPostMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.PostOuterClass.PostObj,
                GRPCService.PostOuterClass.PostObj>(
                  this, METHODID_ADD_POST)))
          .build();
    }
  }

  /**
   */
  public static final class PostStub extends io.grpc.stub.AbstractStub<PostStub> {
    private PostStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PostStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PostStub(channel, callOptions);
    }

    /**
     */
    public void addPost(GRPCService.PostOuterClass.PostObj request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.PostObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddPostMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PostBlockingStub extends io.grpc.stub.AbstractStub<PostBlockingStub> {
    private PostBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PostBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PostBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPCService.PostOuterClass.PostObj addPost(GRPCService.PostOuterClass.PostObj request) {
      return blockingUnaryCall(
          getChannel(), getAddPostMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PostFutureStub extends io.grpc.stub.AbstractStub<PostFutureStub> {
    private PostFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PostFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PostFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.PostOuterClass.PostObj> addPost(
        GRPCService.PostOuterClass.PostObj request) {
      return futureUnaryCall(
          getChannel().newCall(getAddPostMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_POST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PostImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PostImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_POST:
          serviceImpl.addPost((GRPCService.PostOuterClass.PostObj) request,
              (io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.PostObj>) responseObserver);
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

  private static abstract class PostBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PostBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPCService.PostOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Post");
    }
  }

  private static final class PostFileDescriptorSupplier
      extends PostBaseDescriptorSupplier {
    PostFileDescriptorSupplier() {}
  }

  private static final class PostMethodDescriptorSupplier
      extends PostBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PostMethodDescriptorSupplier(String methodName) {
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
      synchronized (PostGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PostFileDescriptorSupplier())
              .addMethod(getAddPostMethod())
              .build();
        }
      }
    }
    return result;
  }
}
