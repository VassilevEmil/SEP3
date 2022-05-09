package group6.semester.project.grpcClient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManagedChannelGetter {

    private static ManagedChannel managedChannel;
    private static Lock lock = new ReentrantLock();

    private ManagedChannelGetter(){

    }

    public  static ManagedChannel getManagedChannel(){
        if (managedChannel==null){
           synchronized (lock){
               if (managedChannel==null){
                  managedChannel= ManagedChannelBuilder.forAddress("localhost", 5250).usePlaintext().build();
               }
           }
        }
        return managedChannel;
    }
}
