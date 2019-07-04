package test.clientstream;

import java.io.IOException;

import com.grpc.clientstream.AdditionServiceGrpc.AdditionServiceImplBase;
import com.grpc.clientstream.Result;
import com.grpc.clientstream.Value;

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
	static class GreeterImpl extends AdditionServiceImplBase{
		
		@Override
		public StreamObserver<Value> getResult(StreamObserver<Result> responseObserver){//参数对应了客户端的responseObserver
			return new StreamObserver<Value>() {

				private int sum=0;
				private int cnt=0;
				private double avg;
				@Override
				public void onCompleted() {//返回给客户端
					// TODO Auto-generated method stub
					avg =1.0*sum/cnt;
					System.out.println(sum);System.out.println(cnt);System.out.println(avg);
					responseObserver.onNext(Result.newBuilder().setSum(sum).setCnt(cnt).setAvg(avg).build());
					responseObserver.onCompleted();
				}

				@Override
				public void onError(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onNext(Value arg0) {//接受客户端的参数
					// TODO Auto-generated method stub
					sum+=arg0.getValue();
					cnt++;
					System.out.println(sum);System.out.println(cnt);System.out.println(avg);
				}
			};
			
		}
	}
}
