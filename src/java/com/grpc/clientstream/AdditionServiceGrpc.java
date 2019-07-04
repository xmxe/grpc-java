package com.grpc.clientstream;

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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: clientstream.proto")
public final class AdditionServiceGrpc {

  private AdditionServiceGrpc() {}

  public static final String SERVICE_NAME = "clientstream.AdditionService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetResultMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.grpc.clientstream.Value,
      com.grpc.clientstream.Result> METHOD_GET_RESULT = getGetResultMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.grpc.clientstream.Value,
      com.grpc.clientstream.Result> getGetResultMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.grpc.clientstream.Value,
      com.grpc.clientstream.Result> getGetResultMethod() {
    return getGetResultMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.grpc.clientstream.Value,
      com.grpc.clientstream.Result> getGetResultMethodHelper() {
    io.grpc.MethodDescriptor<com.grpc.clientstream.Value, com.grpc.clientstream.Result> getGetResultMethod;
    if ((getGetResultMethod = AdditionServiceGrpc.getGetResultMethod) == null) {
      synchronized (AdditionServiceGrpc.class) {
        if ((getGetResultMethod = AdditionServiceGrpc.getGetResultMethod) == null) {
          AdditionServiceGrpc.getGetResultMethod = getGetResultMethod = 
              io.grpc.MethodDescriptor.<com.grpc.clientstream.Value, com.grpc.clientstream.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "clientstream.AdditionService", "getResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.clientstream.Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.clientstream.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new AdditionServiceMethodDescriptorSupplier("getResult"))
                  .build();
          }
        }
     }
     return getGetResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdditionServiceStub newStub(io.grpc.Channel channel) {
    return new AdditionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdditionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AdditionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdditionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AdditionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AdditionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.clientstream.Value> getResult(
        io.grpc.stub.StreamObserver<com.grpc.clientstream.Result> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetResultMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetResultMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.grpc.clientstream.Value,
                com.grpc.clientstream.Result>(
                  this, METHODID_GET_RESULT)))
          .build();
    }
  }

  /**
   */
  public static final class AdditionServiceStub extends io.grpc.stub.AbstractStub<AdditionServiceStub> {
    private AdditionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdditionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdditionServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.clientstream.Value> getResult(
        io.grpc.stub.StreamObserver<com.grpc.clientstream.Result> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetResultMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AdditionServiceBlockingStub extends io.grpc.stub.AbstractStub<AdditionServiceBlockingStub> {
    private AdditionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdditionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdditionServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class AdditionServiceFutureStub extends io.grpc.stub.AbstractStub<AdditionServiceFutureStub> {
    private AdditionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdditionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdditionServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_RESULT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdditionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdditionServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_GET_RESULT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getResult(
              (io.grpc.stub.StreamObserver<com.grpc.clientstream.Result>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AdditionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdditionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.clientstream.clientstreamProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdditionService");
    }
  }

  private static final class AdditionServiceFileDescriptorSupplier
      extends AdditionServiceBaseDescriptorSupplier {
    AdditionServiceFileDescriptorSupplier() {}
  }

  private static final class AdditionServiceMethodDescriptorSupplier
      extends AdditionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AdditionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AdditionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdditionServiceFileDescriptorSupplier())
              .addMethod(getGetResultMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
