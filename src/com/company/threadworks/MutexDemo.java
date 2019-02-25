package com.company.threadworks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexDemo {
    //同一个锁，锁柱2个线程，则这两线程是否有自己执行的原子性，即是交替执行还是独立各自执行

    public static void main(String[] args) {
        ThreadAA tHreadAA = new ThreadAA();

        new Thread(tHreadAA.runnableA).start();
        new Thread(tHreadAA.runnableB).start();
    }
}

class ThreadAA{
    Lock lock =new ReentrantLock();

    Runnable runnableA= new Runnable() {
        @Override
        public void run() {
            lock.lock();
            //synchronized (this) {
                for (int i = 0; i < 99; i++) {
                    System.out.println(Thread.currentThread().getName() + "\r\n      current num is " + i);

                    try {
                        Thread.sleep(100);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            //}
            lock.unlock();

        }
    };

    Runnable runnableB = new Runnable() {
        @Override
        public void run() {
            lock.lock();
            //synchronized (this) {
                for (int i = 0; i < 99; i++) {
                    System.out.println(Thread.currentThread().getName() + "\r\n      current num is " + i);
                    try {
                        Thread.sleep(100);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
           // }
            lock.unlock();
        }
    };


}
