package com.company.threadworks;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService ;
        //executorService= Executors.newSingleThreadExecutor();

        executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Thread(new MyThreadO()));
        executorService.execute(new Thread(new MyThreadO()));

       Future future= executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                return "hello";
            }
        });

       try{
        System.out.println((String)future.get());}
       catch (Exception e){
           e.printStackTrace();
       }
        executorService.shutdown();
    }
}

class MyThreadO implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread()+"is running");
    }
}
