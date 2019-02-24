package com.company.threadworks;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerThreadDemo {

    //使用Timer与TimerTask实现双重定时器

    private static volatile int count = 0;

    protected static class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            count =(count +1)%2;
            System.out.println("boom boom! and this time we get count :"+count+"current time  is :"+LocalDateTime.now().getSecond());

            new Timer().schedule(new MyTimerTask(),2000+2000*count);
        }
    }



    public static void main(String[] args) {

        Timer timer =new Timer();
        timer.schedule(new MyTimerTask(),2000+2000*count);

        while (true){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


}
