package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDeadLock extends Thread{

    //竞争资源
    private static boolean flag1 = true;

    private static boolean flag2=true;
//反证法讨论此单锁思路

    //若只有一个锁，则无论循环如何，第一编都应该被执行，若不然则第二个线程处在相同条件，也不会被执行
    //若在第一个线程由于条件限制没有进入循环，则线程之间不会产生联系，更别说deadlock；
   private static Lock lock = new ReentrantLock();

    @Override
    public void run() {


     if(flag1){
         lock.lock();
         try {
             sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName()+"is running flag1");
         flag2 =false;

         lock.unlock();
     }



     if(flag2){
         lock.lock();

         try {
             sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName()+"is running flag2");
         flag1 =false;
         lock.unlock();
     }
    }


}
