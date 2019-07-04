package test.eachstream;

import java.io.IOException;

import com.grpc.eachstream.CalculateGrpc.CalculateImplBase;
import com.grpc.eachstream.EachStreamProto.Result;
import com.grpc.eachstream.EachStreamProto.Value;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class EachServer {
	private int port = 8851;
	private Server server;
	public void start() throws IOException{
		server = ServerBuilder.forPort(port).addService( new GreeterImpl()).build().start();
		System.out.println("server start....");
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run(){
				System.out.println("**** shutting down gRPC server since JVM is shutting down..");
				EachServer.this.stop();
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
		final EachServer server = new EachServer();
		server.start();
		server.blockUtilShutdown();
	}
	static class GreeterImpl extends CalculateImplBase{
		
		@Override
		public StreamObserver<Value> getResult(StreamObserver<Result> responseObserver){//������Ӧ�˿ͻ��˵�responseObserver
			return new StreamObserver<Value>() {

				private int sum=0;
				private int cnt=0;
				private double avg;
				@Override
				public void onCompleted() {//���ظ��ͻ���
		
					responseObserver.onCompleted();
				}

				@Override
				public void onError(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onNext(Value arg0) {//���ܿͻ��˷��͵Ĳ���
					// TODO Auto-generated method stub
					sum+=arg0.getValue();
					cnt++;
					// TODO Auto-generated method stub
					avg =1.0*sum/cnt;
					System.err.println("value:"+arg0.getValue());
					//Result response = Result.newBuilder().setSum(sum).setCnt(cnt).setAvg(avg).build();
					responseObserver.onNext(Result.newBuilder().setSum(sum).setCnt(cnt).setAvg(avg).build());
					
				}
			};
			
		}
	}
}
