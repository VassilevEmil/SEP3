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
    comments = "Source: category.proto")
public final class CategoryGrpc {

  private CategoryGrpc() {}

  public static final String SERVICE_NAME = "category.Category";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GRPCService.CategoryOuterClass.Empty,
      GRPCService.CategoryOuterClass.ListOfCategoryObj> getGetAllCategoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCategories",
      requestType = GRPCService.CategoryOuterClass.Empty.class,
      responseType = GRPCService.CategoryOuterClass.ListOfCategoryObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPCService.CategoryOuterClass.Empty,
      GRPCService.CategoryOuterClass.ListOfCategoryObj> getGetAllCategoriesMethod() {
    io.grpc.MethodDescriptor<GRPCService.CategoryOuterClass.Empty, GRPCService.CategoryOuterClass.ListOfCategoryObj> getGetAllCategoriesMethod;
    if ((getGetAllCategoriesMethod = CategoryGrpc.getGetAllCategoriesMethod) == null) {
      synchronized (CategoryGrpc.class) {
        if ((getGetAllCategoriesMethod = CategoryGrpc.getGetAllCategoriesMethod) == null) {
          CategoryGrpc.getGetAllCategoriesMethod = getGetAllCategoriesMethod = 
              io.grpc.MethodDescriptor.<GRPCService.CategoryOuterClass.Empty, GRPCService.CategoryOuterClass.ListOfCategoryObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "category.Category", "GetAllCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.CategoryOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.CategoryOuterClass.ListOfCategoryObj.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryMethodDescriptorSupplier("GetAllCategories"))
                  .build();
          }
        }
     }
     return getGetAllCategoriesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CategoryStub newStub(io.grpc.Channel channel) {
    return new CategoryStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CategoryBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CategoryBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CategoryFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CategoryFutureStub(channel);
  }

  /**
   */
  public static abstract class CategoryImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllCategories(GRPCService.CategoryOuterClass.Empty request,
        io.grpc.stub.StreamObserver<GRPCService.CategoryOuterClass.ListOfCategoryObj> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCategoriesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllCategoriesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPCService.CategoryOuterClass.Empty,
                GRPCService.CategoryOuterClass.ListOfCategoryObj>(
                  this, METHODID_GET_ALL_CATEGORIES)))
          .build();
    }
  }

  /**
   */
  public static final class CategoryStub extends io.grpc.stub.AbstractStub<CategoryStub> {
    private CategoryStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryStub(channel, callOptions);
    }

    /**
     */
    public void getAllCategories(GRPCService.CategoryOuterClass.Empty request,
        io.grpc.stub.StreamObserver<GRPCService.CategoryOuterClass.ListOfCategoryObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCategoriesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CategoryBlockingStub extends io.grpc.stub.AbstractStub<CategoryBlockingStub> {
    private CategoryBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPCService.CategoryOuterClass.ListOfCategoryObj getAllCategories(GRPCService.CategoryOuterClass.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCategoriesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CategoryFutureStub extends io.grpc.stub.AbstractStub<CategoryFutureStub> {
    private CategoryFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPCService.CategoryOuterClass.ListOfCategoryObj> getAllCategories(
        GRPCService.CategoryOuterClass.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCategoriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_CATEGORIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CategoryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CategoryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_CATEGORIES:
          serviceImpl.getAllCategories((GRPCService.CategoryOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<GRPCService.CategoryOuterClass.ListOfCategoryObj>) responseObserver);
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

  private static abstract class CategoryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CategoryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPCService.CategoryOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Category");
    }
  }

  private static final class CategoryFileDescriptorSupplier
      extends CategoryBaseDescriptorSupplier {
    CategoryFileDescriptorSupplier() {}
  }

  private static final class CategoryMethodDescriptorSupplier
      extends CategoryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CategoryMethodDescriptorSupplier(String methodName) {
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
      synchronized (CategoryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CategoryFileDescriptorSupplier())
              .addMethod(getGetAllCategoriesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
