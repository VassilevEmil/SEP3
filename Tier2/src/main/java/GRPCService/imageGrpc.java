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
    comments = "Source: image.proto")
public final class imageGrpc {

  private imageGrpc() {}

  public static final String SERVICE_NAME = "image.image";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GRPCService.Image.FileUploadRequest,
      GRPCService.Image.FileUploadResponse> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Upload",
      requestType = GRPCService.Image.FileUploadRequest.class,
      responseType = GRPCService.Image.FileUploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<GRPCService.Image.FileUploadRequest,
      GRPCService.Image.FileUploadResponse> getUploadMethod() {
    io.grpc.MethodDescriptor<GRPCService.Image.FileUploadRequest, GRPCService.Image.FileUploadResponse> getUploadMethod;
    if ((getUploadMethod = imageGrpc.getUploadMethod) == null) {
      synchronized (imageGrpc.class) {
        if ((getUploadMethod = imageGrpc.getUploadMethod) == null) {
          imageGrpc.getUploadMethod = getUploadMethod = 
              io.grpc.MethodDescriptor.<GRPCService.Image.FileUploadRequest, GRPCService.Image.FileUploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "image.image", "Upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Image.FileUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPCService.Image.FileUploadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new imageMethodDescriptorSupplier("Upload"))
                  .build();
          }
        }
     }
     return getUploadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static imageStub newStub(io.grpc.Channel channel) {
    return new imageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static imageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new imageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static imageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new imageFutureStub(channel);
  }

  /**
   */
  public static abstract class imageImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<GRPCService.Image.FileUploadRequest> upload(
        io.grpc.stub.StreamObserver<GRPCService.Image.FileUploadResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUploadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUploadMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                GRPCService.Image.FileUploadRequest,
                GRPCService.Image.FileUploadResponse>(
                  this, METHODID_UPLOAD)))
          .build();
    }
  }

  /**
   */
  public static final class imageStub extends io.grpc.stub.AbstractStub<imageStub> {
    private imageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private imageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected imageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new imageStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<GRPCService.Image.FileUploadRequest> upload(
        io.grpc.stub.StreamObserver<GRPCService.Image.FileUploadResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class imageBlockingStub extends io.grpc.stub.AbstractStub<imageBlockingStub> {
    private imageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private imageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected imageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new imageBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class imageFutureStub extends io.grpc.stub.AbstractStub<imageFutureStub> {
    private imageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private imageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected imageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new imageFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_UPLOAD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final imageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(imageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.upload(
              (io.grpc.stub.StreamObserver<GRPCService.Image.FileUploadResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class imageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    imageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPCService.Image.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("image");
    }
  }

  private static final class imageFileDescriptorSupplier
      extends imageBaseDescriptorSupplier {
    imageFileDescriptorSupplier() {}
  }

  private static final class imageMethodDescriptorSupplier
      extends imageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    imageMethodDescriptorSupplier(String methodName) {
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
      synchronized (imageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new imageFileDescriptorSupplier())
              .addMethod(getUploadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
