package com.company.threadworks;

public class DeadlockDemoPLus {

    //死锁实现
    //死锁也是线程间的一种通信,不过是失败的
    public static void main(String[] args) {

        MyThreadA myThreadA = new MyThreadA();
        new Thread(myThreadA.runnableA).start();

        new Thread(myThreadA.runnableb).start();
    }
}
class MyThreadA {

    private Boolean flag =true;
    private Object o1 = new Object(),o2 = new Object();

    Runnable runnableA = new Runnable() {
        @Override
        public void run() {
            synchronized (o1){
                if(flag){
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                synchronized (o2){
                    System.out.println("lock of lock ,and this thread of "+Thread.currentThread().getName()+"get the lock ,anf proceeds");
                }
            }

        }
    };

    Runnable runnableb = new Runnable() {
        @Override
        public void run() {
            synchronized (o2){
                if(!flag){
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                synchronized (o1){
                    System.out.println("lock of lock ,and this thread of "+Thread.currentThread().getName()+"get the lock ,anf proceeds");
                }
            }
        }
    };

}
