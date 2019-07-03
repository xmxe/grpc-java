package test;

import java.io.IOException;

import com.grpc.helloworld.GreeterGrpc.GreeterImplBase;
import com.grpc.helloworld.HelloReply;
import com.grpc.helloworld.HelloRequest;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HelloWorldServer {
	private int port = 8851;
	private Server server;
	public void start() throws IOException{
		server = ServerBuilder.forPort(port).addService( new GreeterImpl()).build().start();
		System.out.println("server start....");
		Runtime.getRuntime().addShutdownHook(new Thread(()->{
			System.out.println("**** shutting down gRPC server since JVM is shutting down..");
			HelloWorldServer.this.stop();
			System.out.println("*** server shutdown");
		}));
	}
	public void stop(){
		if(server != null){
			server.shutdown();
		}
	}
	
	private void blockUtilShutdown() throws InterruptedException{
		if(server != null){
			server.awaitTermination();
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		final HelloWorldServer server = new HelloWorldServer();
		server.start();//启动服务器并接收客户端的请求
		server.blockUtilShutdown();//会让server阻塞到程序退出为止。
	}
	static class GreeterImpl extends GreeterImplBase{
		public void sayHello(HelloRequest request,StreamObserver<HelloReply> responseObserver){
			System.err.println("service:"+request.getName());
			HelloReply reply = HelloReply.newBuilder().setMessage(("hello:"+request.getName())).build();
			responseObserver.onNext(reply);//用于向客户端返回结果
			responseObserver.onCompleted();//告诉客户端，这次调用已经完成
		}
	}
}
