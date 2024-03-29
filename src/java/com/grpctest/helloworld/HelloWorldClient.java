package com.grpctest.helloworld;

import java.util.concurrent.TimeUnit;

import com.grpc.helloworld.GreeterGrpc;
import com.grpc.helloworld.GreeterGrpc.GreeterBlockingStub;
import com.grpc.helloworld.HelloReply;
import com.grpc.helloworld.HelloRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldClient {
	private final ManagedChannel channel;
	private final GreeterBlockingStub blockingstub;
	public HelloWorldClient(String host,int port){
		this(ManagedChannelBuilder.forAddress(host, port)
		        .usePlaintext()
		        .build());
	}
	HelloWorldClient(ManagedChannel channel) {
	    this.channel = channel;
	    blockingstub = GreeterGrpc.newBlockingStub(channel);
	  }
	public void shutdown() throws InterruptedException{
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	public void greet(String name){
		HelloRequest request = HelloRequest.newBuilder().setName(name).build();
		HelloReply reply = blockingstub.sayHello(request);
		System.out.println(reply.getMessage());
	}
	public static void main(String[] args) throws Exception {
		HelloWorldClient client = new HelloWorldClient("127.0.0.1", 8851);
		try {						 
			 for(int i = 0;i<5;i++){ 
				 client.greet("world:"+i); 
			 } 
		    } finally {
		      client.shutdown();
		    }
	}
}
