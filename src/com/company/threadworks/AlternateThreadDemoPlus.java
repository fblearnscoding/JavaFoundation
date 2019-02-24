package com.company.threadworks;

public class AlternateThreadDemoPlus {



    //使用好notify(),wait()
    public static void main(String[] args) {

        MyWorks mw = new MyWorks();



        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<3;i++){
                mw.methodSub();}
            }
        }).start();


        for(int j=0;j<3;j++){
        mw.methodMain();
        }
    }
}

class MyWorks {

    //  工作内容,规定线程动作
    private Boolean mainFlag =true;

    private Boolean subFlag = true;


   synchronized void methodMain() {

        while(!mainFlag){

            try{
            wait();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(mainFlag)

        for (int i=0;i<5;i++){

            System.out.println("this is mainWork at round "+i);
       }

        mainFlag =false;
        subFlag = true;

        try{
            notify();
            while(!mainFlag){
            wait();}

        }catch (Exception e){
                e.printStackTrace();
        }


    }

   synchronized void methodSub() {
        while(!subFlag){
            try{
            wait();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(subFlag)

            for (int i=0;i<10;i++){

                System.out.println("this is subWork at round "+i);
            }

        subFlag =false;
        mainFlag = true;


            notify();




    }

}
