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
    comments = "Source: bookmark.proto")
public final class BookmarkGrpc {

  private BookmarkGrpc() {}

  public static final String SERVICE_NAME = "bookmark.Bookmark";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GRPCService.BookmarkOuterClass.BookmarkObj,
      GRPCService.BookmarkOuterClass.Message> getAddBoomarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddBoomark",
      requestType = GRPCService.BookmarkOuterClass.BookmarkObj.class,
      responseType = GRPCService.BookmarkOuterClass.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.BookmarkOuterClass.BookmarkObj,
      GRPCService.BookmarkOuterClass.Message> getAddBoomarkMethod() {
    io.grpc.MethodDescriptor<GRPCService.BookmarkOuterClass.BookmarkObj, GRPCService.BookmarkOuterClass.Message> getAddBoomarkMethod;
    if ((getAddBoomarkMethod = BookmarkGrpc.getAddBoomarkMethod) == null) {
      synchronized (BookmarkGrpc.class) {
        if ((getAddBoomarkMethod = BookmarkGrpc.getAddBoomarkMethod) == null) {
          BookmarkGrpc.getAddBoomarkMethod = getAddBoomarkMethod = 
              io.grpc.MethodDescriptor.<GRPCService.BookmarkOuterClass.BookmarkObj, GRPCService.BookmarkOuterClass.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bookmark.Bookmark", "AddBoomark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.BookmarkOuterClass.BookmarkObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.BookmarkOuterClass.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new BookmarkMethodDescriptorSupplier("AddBoomark"))
                  .build();
          }
        }
     }
     return getAddBoomarkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GRPCService.BookmarkOuterClass.StringAndInteger,
      GRPCService.BookmarkOuterClass.Message> getRemoveBookmarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveBookmark",
      requestType = GRPCService.BookmarkOuterClass.StringAndInteger.class,
      responseType = GRPCService.BookmarkOuterClass.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.BookmarkOuterClass.StringAndInteger,
      GRPCService.BookmarkOuterClass.Message> getRemoveBookmarkMethod() {
    io.grpc.MethodDescriptor<GRPCService.BookmarkOuterClass.StringAndInteger, GRPCService.BookmarkOuterClass.Message> getRemoveBookmarkMethod;
    if ((getRemoveBookmarkMethod = BookmarkGrpc.getRemoveBookmarkMethod) == null) {
      synchronized (BookmarkGrpc.class) {
        if ((getRemoveBookmarkMethod = BookmarkGrpc.getRemoveBookmarkMethod) == null) {
          BookmarkGrpc.getRemoveBookmarkMethod = getRemoveBookmarkMethod = 
              io.grpc.MethodDescriptor.<GRPCService.BookmarkOuterClass.StringAndInteger, GRPCService.BookmarkOuterClass.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bookmark.Bookmark", "RemoveBookmark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.BookmarkOuterClass.StringAndInteger.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.BookmarkOuterClass.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new BookmarkMethodDescriptorSupplier("RemoveBookmark"))
                  .build();
          }
        }
     }
     return getRemoveBookmarkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookmarkStub newStub(io.grpc.Channel channel) {
    return new BookmarkStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookmarkBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookmarkBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookmarkFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookmarkFutureStub(channel);
  }

  /**
   */
  public static abstract class BookmarkImplBase implements io.grpc.BindableService {

    /**
     */
    public void addBoomark(GRPCService.BookmarkOuterClass.BookmarkObj request,
        io.grpc.stub.StreamObserver<GRPCService.BookmarkOuterClass.Message> responseObserver) {
      asyncUnimplementedUnaryCall(getAddBoomarkMethod(), responseObserver);
    }

    /**
     */
    public void removeBookmark(GRPCService.BookmarkOuterClass.StringAndInteger request,
        io.grpc.stub.StreamObserver<GRPCService.BookmarkOuterClass.Message> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveBookmarkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddBoomarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.BookmarkOuterClass.BookmarkObj,
                GRPCService.BookmarkOuterClass.Message>(
                  this, METHODID_ADD_BOOMARK)))
          .addMethod(
            getRemoveBookmarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.BookmarkOuterClass.StringAndInteger,
                GRPCService.BookmarkOuterClass.Message>(
                  this, METHODID_REMOVE_BOOKMARK)))
          .build();
    }
  }

  /**
   */
  public static final class BookmarkStub extends io.grpc.stub.AbstractStub<BookmarkStub> {
    private BookmarkStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookmarkStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookmarkStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookmarkStub(channel, callOptions);
    }

    /**
     */
    public void addBoomark(GRPCService.BookmarkOuterClass.BookmarkObj request,
        io.grpc.stub.StreamObserver<GRPCService.BookmarkOuterClass.Message> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddBoomarkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeBookmark(GRPCService.BookmarkOuterClass.StringAndInteger request,
        io.grpc.stub.StreamObserver<GRPCService.BookmarkOuterClass.Message> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveBookmarkMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BookmarkBlockingStub extends io.grpc.stub.AbstractStub<BookmarkBlockingStub> {
    private BookmarkBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookmarkBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookmarkBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookmarkBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPCService.BookmarkOuterClass.Message addBoomark(GRPCService.BookmarkOuterClass.BookmarkObj request) {
      return blockingUnaryCall(
          getChannel(), getAddBoomarkMethod(), getCallOptions(), request);
    }

    /**
     */
    public GRPCService.BookmarkOuterClass.Message removeBookmark(GRPCService.BookmarkOuterClass.StringAndInteger request) {
      return blockingUnaryCall(
          getChannel(), getRemoveBookmarkMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookmarkFutureStub extends io.grpc.stub.AbstractStub<BookmarkFutureStub> {
    private BookmarkFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookmarkFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookmarkFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookmarkFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.BookmarkOuterClass.Message> addBoomark(
        GRPCService.BookmarkOuterClass.BookmarkObj request) {
      return futureUnaryCall(
          getChannel().newCall(getAddBoomarkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.BookmarkOuterClass.Message> removeBookmark(
        GRPCService.BookmarkOuterClass.StringAndInteger request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveBookmarkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_BOOMARK = 0;
  private static final int METHODID_REMOVE_BOOKMARK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookmarkImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookmarkImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_BOOMARK:
          serviceImpl.addBoomark((GRPCService.BookmarkOuterClass.BookmarkObj) request,
              (io.grpc.stub.StreamObserver<GRPCService.BookmarkOuterClass.Message>) responseObserver);
          break;
        case METHODID_REMOVE_BOOKMARK:
          serviceImpl.removeBookmark((GRPCService.BookmarkOuterClass.StringAndInteger) request,
              (io.grpc.stub.StreamObserver<GRPCService.BookmarkOuterClass.Message>) responseObserver);
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

  private static abstract class BookmarkBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookmarkBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPCService.BookmarkOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bookmark");
    }
  }

  private static final class BookmarkFileDescriptorSupplier
      extends BookmarkBaseDescriptorSupplier {
    BookmarkFileDescriptorSupplier() {}
  }

  private static final class BookmarkMethodDescriptorSupplier
      extends BookmarkBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookmarkMethodDescriptorSupplier(String methodName) {
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
      synchronized (BookmarkGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookmarkFileDescriptorSupplier())
              .addMethod(getAddBoomarkMethod())
              .addMethod(getRemoveBookmarkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
