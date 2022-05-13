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
  private static volatile io.grpc.MethodDescriptor<GRPCService.PostOuterClass.TransferPostWithSubcategoryId,
      GRPCService.PostOuterClass.PostObj> getAddPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPost",
      requestType = GRPCService.PostOuterClass.TransferPostWithSubcategoryId.class,
      responseType = GRPCService.PostOuterClass.PostObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.PostOuterClass.TransferPostWithSubcategoryId,
      GRPCService.PostOuterClass.PostObj> getAddPostMethod() {
    io.grpc.MethodDescriptor<GRPCService.PostOuterClass.TransferPostWithSubcategoryId, GRPCService.PostOuterClass.PostObj> getAddPostMethod;
    if ((getAddPostMethod = PostGrpc.getAddPostMethod) == null) {
      synchronized (PostGrpc.class) {
        if ((getAddPostMethod = PostGrpc.getAddPostMethod) == null) {
          PostGrpc.getAddPostMethod = getAddPostMethod = 
              io.grpc.MethodDescriptor.<GRPCService.PostOuterClass.TransferPostWithSubcategoryId, GRPCService.PostOuterClass.PostObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "post.Post", "AddPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.TransferPostWithSubcategoryId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.PostObj.getDefaultInstance()))
                  .setSchemaDescriptor(new PostMethodDescriptorSupplier("AddPost"))
                  .build();
          }
        }
     }
     return getAddPostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GRPCService.PostOuterClass.StringAndInteger,
      GRPCService.PostOuterClass.ListOfPostObj> getSearchPostsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchPosts",
      requestType = GRPCService.PostOuterClass.StringAndInteger.class,
      responseType = GRPCService.PostOuterClass.ListOfPostObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.PostOuterClass.StringAndInteger,
      GRPCService.PostOuterClass.ListOfPostObj> getSearchPostsMethod() {
    io.grpc.MethodDescriptor<GRPCService.PostOuterClass.StringAndInteger, GRPCService.PostOuterClass.ListOfPostObj> getSearchPostsMethod;
    if ((getSearchPostsMethod = PostGrpc.getSearchPostsMethod) == null) {
      synchronized (PostGrpc.class) {
        if ((getSearchPostsMethod = PostGrpc.getSearchPostsMethod) == null) {
          PostGrpc.getSearchPostsMethod = getSearchPostsMethod = 
              io.grpc.MethodDescriptor.<GRPCService.PostOuterClass.StringAndInteger, GRPCService.PostOuterClass.ListOfPostObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "post.Post", "SearchPosts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.StringAndInteger.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.ListOfPostObj.getDefaultInstance()))
                  .setSchemaDescriptor(new PostMethodDescriptorSupplier("SearchPosts"))
                  .build();
          }
        }
     }
     return getSearchPostsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GRPCService.PostOuterClass.RequestModel,
      GRPCService.PostOuterClass.ListOfPostObj> getGetAllPostsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllPosts",
      requestType = GRPCService.PostOuterClass.RequestModel.class,
      responseType = GRPCService.PostOuterClass.ListOfPostObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.PostOuterClass.RequestModel,
      GRPCService.PostOuterClass.ListOfPostObj> getGetAllPostsMethod() {
    io.grpc.MethodDescriptor<GRPCService.PostOuterClass.RequestModel, GRPCService.PostOuterClass.ListOfPostObj> getGetAllPostsMethod;
    if ((getGetAllPostsMethod = PostGrpc.getGetAllPostsMethod) == null) {
      synchronized (PostGrpc.class) {
        if ((getGetAllPostsMethod = PostGrpc.getGetAllPostsMethod) == null) {
          PostGrpc.getGetAllPostsMethod = getGetAllPostsMethod = 
              io.grpc.MethodDescriptor.<GRPCService.PostOuterClass.RequestModel, GRPCService.PostOuterClass.ListOfPostObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "post.Post", "GetAllPosts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.RequestModel.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.ListOfPostObj.getDefaultInstance()))
                  .setSchemaDescriptor(new PostMethodDescriptorSupplier("GetAllPosts"))
                  .build();
          }
        }
     }
     return getGetAllPostsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GRPCService.PostOuterClass.IdWithInteger,
      GRPCService.PostOuterClass.PostObj> getGetPostDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPostDetails",
      requestType = GRPCService.PostOuterClass.IdWithInteger.class,
      responseType = GRPCService.PostOuterClass.PostObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.PostOuterClass.IdWithInteger,
      GRPCService.PostOuterClass.PostObj> getGetPostDetailsMethod() {
    io.grpc.MethodDescriptor<GRPCService.PostOuterClass.IdWithInteger, GRPCService.PostOuterClass.PostObj> getGetPostDetailsMethod;
    if ((getGetPostDetailsMethod = PostGrpc.getGetPostDetailsMethod) == null) {
      synchronized (PostGrpc.class) {
        if ((getGetPostDetailsMethod = PostGrpc.getGetPostDetailsMethod) == null) {
          PostGrpc.getGetPostDetailsMethod = getGetPostDetailsMethod = 
              io.grpc.MethodDescriptor.<GRPCService.PostOuterClass.IdWithInteger, GRPCService.PostOuterClass.PostObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "post.Post", "GetPostDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.IdWithInteger.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.PostOuterClass.PostObj.getDefaultInstance()))
                  .setSchemaDescriptor(new PostMethodDescriptorSupplier("GetPostDetails"))
                  .build();
          }
        }
     }
     return getGetPostDetailsMethod;
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
    public void addPost(GRPCService.PostOuterClass.TransferPostWithSubcategoryId request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.PostObj> responseObserver) {
      asyncUnimplementedUnaryCall(getAddPostMethod(), responseObserver);
    }

    /**
     */
    public void searchPosts(GRPCService.PostOuterClass.StringAndInteger request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.ListOfPostObj> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchPostsMethod(), responseObserver);
    }

    /**
     */
    public void getAllPosts(GRPCService.PostOuterClass.RequestModel request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.ListOfPostObj> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllPostsMethod(), responseObserver);
    }

    /**
     */
    public void getPostDetails(GRPCService.PostOuterClass.IdWithInteger request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.PostObj> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPostDetailsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddPostMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.PostOuterClass.TransferPostWithSubcategoryId,
                GRPCService.PostOuterClass.PostObj>(
                  this, METHODID_ADD_POST)))
          .addMethod(
            getSearchPostsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.PostOuterClass.StringAndInteger,
                GRPCService.PostOuterClass.ListOfPostObj>(
                  this, METHODID_SEARCH_POSTS)))
          .addMethod(
            getGetAllPostsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.PostOuterClass.RequestModel,
                GRPCService.PostOuterClass.ListOfPostObj>(
                  this, METHODID_GET_ALL_POSTS)))
          .addMethod(
            getGetPostDetailsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.PostOuterClass.IdWithInteger,
                GRPCService.PostOuterClass.PostObj>(
                  this, METHODID_GET_POST_DETAILS)))
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
    public void addPost(GRPCService.PostOuterClass.TransferPostWithSubcategoryId request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.PostObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddPostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchPosts(GRPCService.PostOuterClass.StringAndInteger request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.ListOfPostObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchPostsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllPosts(GRPCService.PostOuterClass.RequestModel request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.ListOfPostObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllPostsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPostDetails(GRPCService.PostOuterClass.IdWithInteger request,
        io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.PostObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPostDetailsMethod(), getCallOptions()), request, responseObserver);
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
    public GRPCService.PostOuterClass.PostObj addPost(GRPCService.PostOuterClass.TransferPostWithSubcategoryId request) {
      return blockingUnaryCall(
          getChannel(), getAddPostMethod(), getCallOptions(), request);
    }

    /**
     */
    public GRPCService.PostOuterClass.ListOfPostObj searchPosts(GRPCService.PostOuterClass.StringAndInteger request) {
      return blockingUnaryCall(
          getChannel(), getSearchPostsMethod(), getCallOptions(), request);
    }

    /**
     */
    public GRPCService.PostOuterClass.ListOfPostObj getAllPosts(GRPCService.PostOuterClass.RequestModel request) {
      return blockingUnaryCall(
          getChannel(), getGetAllPostsMethod(), getCallOptions(), request);
    }

    /**
     */
    public GRPCService.PostOuterClass.PostObj getPostDetails(GRPCService.PostOuterClass.IdWithInteger request) {
      return blockingUnaryCall(
          getChannel(), getGetPostDetailsMethod(), getCallOptions(), request);
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
        GRPCService.PostOuterClass.TransferPostWithSubcategoryId request) {
      return futureUnaryCall(
          getChannel().newCall(getAddPostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.PostOuterClass.ListOfPostObj> searchPosts(
        GRPCService.PostOuterClass.StringAndInteger request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchPostsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.PostOuterClass.ListOfPostObj> getAllPosts(
        GRPCService.PostOuterClass.RequestModel request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllPostsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.PostOuterClass.PostObj> getPostDetails(
        GRPCService.PostOuterClass.IdWithInteger request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPostDetailsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_POST = 0;
  private static final int METHODID_SEARCH_POSTS = 1;
  private static final int METHODID_GET_ALL_POSTS = 2;
  private static final int METHODID_GET_POST_DETAILS = 3;

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
          serviceImpl.addPost((GRPCService.PostOuterClass.TransferPostWithSubcategoryId) request,
              (io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.PostObj>) responseObserver);
          break;
        case METHODID_SEARCH_POSTS:
          serviceImpl.searchPosts((GRPCService.PostOuterClass.StringAndInteger) request,
              (io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.ListOfPostObj>) responseObserver);
          break;
        case METHODID_GET_ALL_POSTS:
          serviceImpl.getAllPosts((GRPCService.PostOuterClass.RequestModel) request,
              (io.grpc.stub.StreamObserver<GRPCService.PostOuterClass.ListOfPostObj>) responseObserver);
          break;
        case METHODID_GET_POST_DETAILS:
          serviceImpl.getPostDetails((GRPCService.PostOuterClass.IdWithInteger) request,
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
              .addMethod(getSearchPostsMethod())
              .addMethod(getGetAllPostsMethod())
              .addMethod(getGetPostDetailsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
