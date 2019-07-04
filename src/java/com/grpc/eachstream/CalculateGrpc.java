package com.grpc.eachstream;

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
    comments = "Source: eachstream.proto")
public final class CalculateGrpc {

  private CalculateGrpc() {}

  public static final String SERVICE_NAME = "eachstream.Calculate";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetResultMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.grpc.eachstream.EachStreamProto.Value,
      com.grpc.eachstream.EachStreamProto.Result> METHOD_GET_RESULT = getGetResultMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.grpc.eachstream.EachStreamProto.Value,
      com.grpc.eachstream.EachStreamProto.Result> getGetResultMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.grpc.eachstream.EachStreamProto.Value,
      com.grpc.eachstream.EachStreamProto.Result> getGetResultMethod() {
    return getGetResultMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.grpc.eachstream.EachStreamProto.Value,
      com.grpc.eachstream.EachStreamProto.Result> getGetResultMethodHelper() {
    io.grpc.MethodDescriptor<com.grpc.eachstream.EachStreamProto.Value, com.grpc.eachstream.EachStreamProto.Result> getGetResultMethod;
    if ((getGetResultMethod = CalculateGrpc.getGetResultMethod) == null) {
      synchronized (CalculateGrpc.class) {
        if ((getGetResultMethod = CalculateGrpc.getGetResultMethod) == null) {
          CalculateGrpc.getGetResultMethod = getGetResultMethod = 
              io.grpc.MethodDescriptor.<com.grpc.eachstream.EachStreamProto.Value, com.grpc.eachstream.EachStreamProto.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "eachstream.Calculate", "getResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.eachstream.EachStreamProto.Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.eachstream.EachStreamProto.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculateMethodDescriptorSupplier("getResult"))
                  .build();
          }
        }
     }
     return getGetResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculateStub newStub(io.grpc.Channel channel) {
    return new CalculateStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculateBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculateBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculateFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculateFutureStub(channel);
  }

  /**
   */
  public static abstract class CalculateImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.eachstream.EachStreamProto.Value> getResult(
        io.grpc.stub.StreamObserver<com.grpc.eachstream.EachStreamProto.Result> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetResultMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetResultMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.grpc.eachstream.EachStreamProto.Value,
                com.grpc.eachstream.EachStreamProto.Result>(
                  this, METHODID_GET_RESULT)))
          .build();
    }
  }

  /**
   */
  public static final class CalculateStub extends io.grpc.stub.AbstractStub<CalculateStub> {
    private CalculateStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculateStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculateStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculateStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.eachstream.EachStreamProto.Value> getResult(
        io.grpc.stub.StreamObserver<com.grpc.eachstream.EachStreamProto.Result> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetResultMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CalculateBlockingStub extends io.grpc.stub.AbstractStub<CalculateBlockingStub> {
    private CalculateBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculateBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculateBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculateBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class CalculateFutureStub extends io.grpc.stub.AbstractStub<CalculateFutureStub> {
    private CalculateFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculateFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculateFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculateFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_RESULT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculateImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculateImplBase serviceImpl, int methodId) {
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
              (io.grpc.stub.StreamObserver<com.grpc.eachstream.EachStreamProto.Result>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalculateBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculateBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.eachstream.EachStreamProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calculate");
    }
  }

  private static final class CalculateFileDescriptorSupplier
      extends CalculateBaseDescriptorSupplier {
    CalculateFileDescriptorSupplier() {}
  }

  private static final class CalculateMethodDescriptorSupplier
      extends CalculateBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculateMethodDescriptorSupplier(String methodName) {
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
      synchronized (CalculateGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculateFileDescriptorSupplier())
              .addMethod(getGetResultMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
