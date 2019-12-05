package com.grpctest.serverstream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.grpc.serverstream.IP;
import com.grpc.serverstream.Name;
import com.grpc.serverstream.NameServiceGrpc;
import com.grpc.serverstream.NameServiceGrpc.NameServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class StreamClient {
	private final ManagedChannel channel;
	private final NameServiceBlockingStub blockingstub;
	public StreamClient(String host,int port){
		this(ManagedChannelBuilder.forAddress(host, port)
		        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
		        // needing certificates.
		        .usePlaintext()
		        .build());
	}
	StreamClient(ManagedChannel channel) {
	    this.channel = channel;
	    blockingstub = NameServiceGrpc.newBlockingStub(channel);
	  }
	public void shutdown() throws InterruptedException{
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	public List<IP> greet(String n){
		List<IP> list = new ArrayList<>();
		Name na = Name.newBuilder().setName(n).build();
		Iterator<IP> ity =  blockingstub.getIpByName(na);
		while(ity.hasNext()){
			list.add(ity.next());
		}
		return list;
	}
	public static void main(String[] args) throws Exception {
		StreamClient client = new StreamClient("127.0.0.1", 8851);
		try{
			List<IP> re = client.greet("a");
			for(int i =0;i<re.size();i++){
				System.out.println("get result from "+re.get(i)+" as param is");
			}
		}finally{
			client.shutdown();
		}			
		
	}
}
