package com.company.threadworks;

import java.util.concurrent.Semaphore;

public class ThreadCommunicationDemo {
    //3个线程,a,b线程需要c线程的数据才能运行
    //几个runnable?
    //semaphore?
    public static void main(String[] args) {
        ShareDataCom shareDataCom =new ShareDataCom();
        new Thread(new MyRunnableOO(shareDataCom)).start();
        new Thread(new MyRunnableAA(shareDataCom)).start();
        new Thread(new MyRunnableBB(shareDataCom)).start();

    }
}

class MyRunnableOO implements Runnable{
    ShareDataCom shareDataCom;

    public MyRunnableOO (ShareDataCom shareDataCom){
        this.shareDataCom=shareDataCom;
    }
    @Override
    public void run() {
        shareDataCom.methodA();
    }
}

class MyRunnableAA implements Runnable{
    ShareDataCom shareDataCom;

    public MyRunnableAA (ShareDataCom shareDataCom){
        this.shareDataCom=shareDataCom;
    }
    @Override
    public void run() {
        shareDataCom.methodB();
    }
}

class MyRunnableBB implements Runnable{
    ShareDataCom shareDataCom;

    public MyRunnableBB (ShareDataCom shareDataCom){
        this.shareDataCom=shareDataCom;
    }
    @Override
    public void run() {
        shareDataCom.methodC();
    }
}


class ShareDataCom{
    private int a=0;
    private int b=0;
    private int c=0;

    private Semaphore semaphore=new Semaphore(0);

    synchronized  void methodA(){
        //trySemaphore();
        a=1;
        System.out.println("now we get value of a comparing with 1      "+(a==1)+"    "+a);
        currentThread();
        semaphore.release(2);
    }

    synchronized  void methodB(){
        trySemaphore();
        if(a==1){


            b=2;
            System.out.println("now we get value of b comparing with 2     "+(b==2)+"    "+b);
            currentThread();
            //semaphore.release(1);
        }

    }

    synchronized  void methodC(){
        trySemaphore();

        if(b==2){

            c=3;
            System.out.println("now we get value of c comparing with 3      "+(c==3)+"    "+c);

            currentThread();
            //semaphore.release();
        }

    }



    void trySemaphore(){
        try {
            semaphore.acquire();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    void currentThread(){
        System.out.println("currentThread:   "+Thread.currentThread().getName()+Thread.currentThread().getId());
    }

}
