package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDeadLock2 extends Thread{

    int flag=1;

    public MyDeadLock2(int flag){
        this.flag=flag;
    }

    private static Lock lock1= new ReentrantLock(),lock2=new ReentrantLock();

    @Override
    public void run() {

        if(flag==1){

            lock1.lock();
            System.out.println(Thread.currentThread().getName()+"get lock1");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock2.lock();
            System.out.println(Thread.currentThread().getName()+"get lock2");

            lock2.unlock();
            System.out.println(Thread.currentThread().getName()+"released by lock 2");

            lock1.unlock();
            System.out.println(Thread.currentThread().getName()+"released by lock 1");

        }

        if(flag==0){

            lock2.lock();
            System.out.println(Thread.currentThread().getName()+"get lock2");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            lock1.lock();
            System.out.println(Thread.currentThread().getName()+"get lock1");

            lock1.unlock();
            System.out.println(Thread.currentThread().getName()+"released by lock 1");
            lock2.unlock();
            System.out.println(Thread.currentThread().getName()+"released by lock 2");
        }

    }
}
