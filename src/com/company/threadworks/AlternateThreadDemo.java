package com.company.threadworks;

public class AlternateThreadDemo {

    //子线程与主线程交替执行，且这个交替进行指定次数

    private static Boolean fly=true;

    public static void main(String[] args) {

        int i = 0;


        while (i++<3){

            new Thread(new ThreadFoo(fly)).start();
           /* try {
                Thread.sleep(1000);
            }catch(Exception e){

            }*/
            new Thread(new ThreadTom(fly)).start();



        }
    }

}

class ThreadFoo extends Thread{

    private Boolean work;

    private  int workRounds = 0;

    public ThreadFoo(Boolean work){
        this.work = work;
    }

    @Override
    public void run() {


        while (work){
            System.out.println("this is Thread of Foo ,and this is my work round of "+workRounds);

            if (workRounds++==10){
                work = !work;
            }
        }
    }
}

class ThreadTom extends Thread{

    private Boolean play ;

    private int playRounds=0;

    public ThreadTom( Boolean play){
        this.play=play;
    }

    @Override
    public void run() {
        //super.run();
        while (play){
            System.out.println("this is Thread of Tom ,and this is my play round of "+playRounds);

            if (playRounds++==5){
                play = !play;
            }
        }
    }
}