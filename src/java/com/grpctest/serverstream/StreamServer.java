package com.grpctest.serverstream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.grpc.serverstream.IP;
import com.grpc.serverstream.Name;
import com.grpc.serverstream.NameServiceGrpc.NameServiceImplBase;

import com.entity.DataType;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class StreamServer {
	private int port = 8851;
	private Server server;
	public void start() throws IOException{
		server = ServerBuilder.forPort(port).addService( new GreeterImpl()).build().start();
		System.out.println("server start....");
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run(){
				System.out.println("**** shutting down gRPC server since JVM is shutting down..");
				StreamServer.this.stop();
				System.out.println("*** server shutdown");
			}
		});
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
		System.out.println("new server");
		final StreamServer server = new StreamServer();
		server.start();
		server.blockUtilShutdown();
	}
	static class GreeterImpl extends NameServiceImplBase{
		private List<DataType> list = new ArrayList<>();
		public GreeterImpl(){
			list.add(new DataType(Name.newBuilder().setName("a").build(),IP.newBuilder().setIP("111").build()));
			list.add(new DataType(Name.newBuilder().setName("b").build(),IP.newBuilder().setIP("222").build()));
		}
		@Override
		public void getIpByName(Name request,StreamObserver<IP> responseObserver){
			Iterator<DataType> it = list.iterator();
			while(it.hasNext()){
				DataType d = it.next();
				//if(request.getName().equals(d.getName().getName())){
					System.err.println(d.getIp().getIP());
					responseObserver.onNext(d.getIp());
				//}
			}
			responseObserver.onCompleted();
		}
	}
}
