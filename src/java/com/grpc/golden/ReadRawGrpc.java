package com.grpc.golden;

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
    comments = "Source: golden.proto")
public final class ReadRawGrpc {

  private ReadRawGrpc() {}

  public static final String SERVICE_NAME = "golden.ReadRaw";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReadRawValuesModelMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.grpc.golden.GoldenProto.Request,
      com.grpc.golden.GoldenProto.LightModelList> METHOD_READ_RAW_VALUES_MODEL = getReadRawValuesModelMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.grpc.golden.GoldenProto.Request,
      com.grpc.golden.GoldenProto.LightModelList> getReadRawValuesModelMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.grpc.golden.GoldenProto.Request,
      com.grpc.golden.GoldenProto.LightModelList> getReadRawValuesModelMethod() {
    return getReadRawValuesModelMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.grpc.golden.GoldenProto.Request,
      com.grpc.golden.GoldenProto.LightModelList> getReadRawValuesModelMethodHelper() {
    io.grpc.MethodDescriptor<com.grpc.golden.GoldenProto.Request, com.grpc.golden.GoldenProto.LightModelList> getReadRawValuesModelMethod;
    if ((getReadRawValuesModelMethod = ReadRawGrpc.getReadRawValuesModelMethod) == null) {
      synchronized (ReadRawGrpc.class) {
        if ((getReadRawValuesModelMethod = ReadRawGrpc.getReadRawValuesModelMethod) == null) {
          ReadRawGrpc.getReadRawValuesModelMethod = getReadRawValuesModelMethod = 
              io.grpc.MethodDescriptor.<com.grpc.golden.GoldenProto.Request, com.grpc.golden.GoldenProto.LightModelList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "golden.ReadRaw", "readRawValuesModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.golden.GoldenProto.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.golden.GoldenProto.LightModelList.getDefaultInstance()))
                  .setSchemaDescriptor(new ReadRawMethodDescriptorSupplier("readRawValuesModel"))
                  .build();
          }
        }
     }
     return getReadRawValuesModelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReadRawStub newStub(io.grpc.Channel channel) {
    return new ReadRawStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReadRawBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReadRawBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReadRawFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReadRawFutureStub(channel);
  }

  /**
   */
  public static abstract class ReadRawImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.golden.GoldenProto.Request> readRawValuesModel(
        io.grpc.stub.StreamObserver<com.grpc.golden.GoldenProto.LightModelList> responseObserver) {
      return asyncUnimplementedStreamingCall(getReadRawValuesModelMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReadRawValuesModelMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.grpc.golden.GoldenProto.Request,
                com.grpc.golden.GoldenProto.LightModelList>(
                  this, METHODID_READ_RAW_VALUES_MODEL)))
          .build();
    }
  }

  /**
   */
  public static final class ReadRawStub extends io.grpc.stub.AbstractStub<ReadRawStub> {
    private ReadRawStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReadRawStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReadRawStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReadRawStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.golden.GoldenProto.Request> readRawValuesModel(
        io.grpc.stub.StreamObserver<com.grpc.golden.GoldenProto.LightModelList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getReadRawValuesModelMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ReadRawBlockingStub extends io.grpc.stub.AbstractStub<ReadRawBlockingStub> {
    private ReadRawBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReadRawBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReadRawBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReadRawBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ReadRawFutureStub extends io.grpc.stub.AbstractStub<ReadRawFutureStub> {
    private ReadRawFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReadRawFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReadRawFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReadRawFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_READ_RAW_VALUES_MODEL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReadRawImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReadRawImplBase serviceImpl, int methodId) {
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
        case METHODID_READ_RAW_VALUES_MODEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.readRawValuesModel(
              (io.grpc.stub.StreamObserver<com.grpc.golden.GoldenProto.LightModelList>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ReadRawBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReadRawBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.golden.GoldenProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReadRaw");
    }
  }

  private static final class ReadRawFileDescriptorSupplier
      extends ReadRawBaseDescriptorSupplier {
    ReadRawFileDescriptorSupplier() {}
  }

  private static final class ReadRawMethodDescriptorSupplier
      extends ReadRawBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReadRawMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReadRawGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReadRawFileDescriptorSupplier())
              .addMethod(getReadRawValuesModelMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
