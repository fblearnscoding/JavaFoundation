package com.company.threadworks;


public class RunnableDemo {
    public static void main(String[] args) {
        Runnable thread=new MyRunnableA();
        for(int i=0;i<100;i++){
            new Thread(thread).start();
        }
    }
}

class MyRunnableA implements Runnable{
    ShareData shareData=new ShareData();
    @Override
    public void run() {
        shareData.dec();
    }
}

class ShareData{
    private volatile int leftOver = 100;

    public int getLeftOver() {
        return leftOver;
    }

    synchronized void dec(){
        if (leftOver>1) {
            System.out.println("ticket selling,Thread" + Thread.currentThread() + "\r\n" + "get the ticket of " + leftOver);
            leftOver -= 2;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    synchronized  void inc (){
        if(leftOver<100 && leftOver>0) {
            leftOver++;
            System.out.println("ticket making,Thread" + Thread.currentThread() + "\r\n" + "make a new ticket ,and current ticket num is " + leftOver);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}