package com.company.threadworks;

public class VolatileDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();

        for (int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.inc();
                }
            }).start();
        }
    }
}
class Counter {
    private volatile int count = 0;

   synchronized void inc (){
        count++;
        System.out.println("current value of count is "+count);
    }
}
