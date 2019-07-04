package test.clientstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.grpc.clientstream.AdditionServiceGrpc;
import com.grpc.clientstream.Result;
import com.grpc.clientstream.Value;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class StreamClient {

    private static final String DEFAULT_HOST = "localhost";

    private static final int DEFAULT_PORT = 8851;

    private static final int VALUE_NUM = 10;

    private static final int VALUE_UPPER_BOUND = 10;

    private Logger logger = Logger.getLogger(StreamClient.class.getName());

    private ManagedChannel managedChannel;

    //�����������ڿͻ��˱��ص���
    //private AdditionServiceGrpc.AdditionServiceBlockingStub additionServiceBlockingStub;

    //�������첽������
    private AdditionServiceGrpc.AdditionServiceStub additionServiceStub;

    public StreamClient(String host, int port) {

        this(ManagedChannelBuilder.forAddress(host,port).usePlaintext(true).build());

    }

    public StreamClient(ManagedChannel managedChannel) {
        this.managedChannel = managedChannel;
        this.additionServiceStub = AdditionServiceGrpc.newStub(managedChannel);
    }

//    public void shutdown() throws InterruptedException {
//        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//    }

    public void getResult(final CallBack callBack, List<Integer> nums){

        //�жϵ���״̬�����ڲ����б����ʣ���Ҫ��final����
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        StreamObserver<Result> responseObserver = new StreamObserver<Result>() {
            public void onNext(Result result) {
                //��̬�����ص�
                CallBack.callBackStatic(result);

                //ʵ�������ص�
                //callBack.setResult(result);
                //callBack.callBackInstance();
            }

            public void onError(Throwable throwable) {

                countDownLatch.countDown();
            }

            public void onCompleted() {

                countDownLatch.countDown();
            }

        };

        StreamObserver<Value> requestObserver = additionServiceStub.getResult(responseObserver);//���͸������

        for(int i=0;i<nums.size();i++){
            Value value = Value.newBuilder().setValue(nums.get(i)).build();
            requestObserver.onNext(value);

            //�жϵ��ý���״̬��������������Ѿ������������������ݲ��ᱨ�����ǻᱻ����
          /*  if(countDownLatch.getCount() == 0){
                return;
            }*/
        }
        //�첽�����޷�ȷ��onNext��onComplete������Ⱥ�˳��
        requestObserver.onCompleted();

        try {
            //����ڹ涨ʱ����û�������꣬���ó���ֹͣ
            if(!countDownLatch.await(5,TimeUnit.MINUTES)){
            	System.out.println("not complete in time");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public void shutdown() throws InterruptedException{
    	managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
    public static void main(String[] args) throws InterruptedException {

        StreamClient additionClient = new StreamClient(DEFAULT_HOST,DEFAULT_PORT);

        //����ʵ�������ص�
        CallBack callBack = new CallBack();

        //����valueֵ
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();

        for(int i=0; i<VALUE_NUM; i++){
            //��������� 0-VALUE_UPPER_BOUND ���ȷֲ�
            int value = random.nextInt(VALUE_UPPER_BOUND);

            System.out.println(i + ":" + value);

            list.add(value);
        }

        System.out.println("*************************getting result from server***************************");

        additionClient.getResult(callBack, list);
        additionClient.shutdown();

    }

}


class CallBack {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static void callBackStatic(Result result){
        System.out.println("get result from server...sum:" +
                result.getSum() +
                " count:" +
                result.getCnt() +
                " avg:" + result.getAvg());
    }

    public void callBackInstance(){
        System.out.println("get result from server...sum:" +
                result.getSum() +
                " count:" +
                result.getCnt() +
                " avg:" + result.getAvg());
    }

}