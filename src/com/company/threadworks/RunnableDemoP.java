package com.company.threadworks;

public class RunnableDemoP {

    //不同线程对于同一个数据源有不同操作
    public static void main(String[] args) {

        ShareData shareData = new ShareData();
        Runnable runnableA=new MyRunnablePP(shareData);
        Runnable runnableB = new MyRunnablePPP(shareData);
        for (int i=0;i<100;i++){
            if(shareData.getLeftOver()>0)

                if(i%2==0){
                new Thread(runnableA).start();
            }
            new Thread(runnableB).start();

        }
    }

}

class MyRunnablePP implements Runnable{

    private ShareData shareData;

    public MyRunnablePP(ShareData shareData){
        this.shareData=shareData;
    }

    @Override
    public void run() {
        shareData.inc();
    }
}

class MyRunnablePPP implements Runnable{
    private ShareData shareData;

    public MyRunnablePPP(ShareData shareData){
        this.shareData=shareData;
    }
    @Override
    public void run() {
        shareData.dec();

    }
}
