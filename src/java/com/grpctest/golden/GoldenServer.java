package com.grpctest.golden;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.grpc.golden.GoldenProto.LightModelList;
import com.grpc.golden.GoldenProto.LightModelList.Builder;
import com.grpc.golden.GoldenProto.Request;
import com.grpc.golden.ReadRawGrpc.ReadRawImplBase;
//import com.lnsoft.golden.LightRead;
//import com.lnsoft.light.LightModel;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class GoldenServer {
	private int port = 8851;
	private Server server;
	public void start() throws IOException{
		server = ServerBuilder.forPort(port).addService( new GreeterImpl()).build().start();
		System.out.println("server start....");
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run(){
				System.out.println("**** shutting down gRPC server since JVM is shutting down..");
				GoldenServer.this.stop();
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
		final GoldenServer server = new GoldenServer();
		server.start();
		server.blockUtilShutdown();
	}
	static class GreeterImpl extends ReadRawImplBase{
		
		@Override
		public StreamObserver<Request> readRawValuesModel(StreamObserver<LightModelList> responseObserver){//参数对应了客户端的responseObserver
			return new StreamObserver<Request>() {
				private String startTime;
				private String endTime;
				private String real_tag;
				
				@Override
				public void onCompleted() {//服务端返回数据 处理逻辑
					// TODO Auto-generated method stub
					DateFormat   formatter   = 	new   SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
					Date now_s = null;
					Date now_e = null;
					try {
						now_s = formatter.parse(startTime);
						now_e = formatter.parse(endTime);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					Builder builder = LightModelList.newBuilder();
//					List<LightModel<Object>> valuesModel = LightRead.readRawValuesModel(now_s,now_e,real_tag);
//					for(LightModel<Object> light : valuesModel){
//						boolean isGood = light.getIsgood();
//						String tagName = light.getTagName();
//						String tagValue = light.getTagValueString();
//						String tagTime = String.valueOf(light.getTagTime());
//						int quality = light.getQuality();
//						boolean steps = light.getSteps();
//						
//						builder.addLightmodel(
//						com.grpc.golden.GoldenProto.LightModel.newBuilder().setIsGood(isGood).
//						setTagName(tagName).setTagValue(tagValue).setTagTime(tagTime).setQuality(quality).setSetps(steps).
//						build()
//						);
//						
//					}
					LightModelList list = builder.build();
					
					responseObserver.onNext(list);//②
					responseObserver.onCompleted();
				}

				@Override
				public void onError(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onNext(Request request) {//①服务端接收客户端的参数(对应客户端的 requestObserver.onNext(value))
					endTime = request.getEndTime();
					startTime = request.getStartTime();
					real_tag = request.getRealTag();
					System.out.println("startTime:"+startTime+"------"+
					"endTime:"+endTime+"------"+"real_tag:"+real_tag);
				}

				
			};
			
		}
	}
}
