package com.company;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {



    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<10000;i++){
            list.add(i);
        }


        //结果显示，两种方法传统方法更加快速，效率之差达数十倍
        //new Calculate(list).byTradition();
        //new Calculate(list).byLambda();
       int d= list.stream().map((cost)->cost+1*cost).reduce((aa,cost)->aa+cost).get();
        System.out.println("sum is "+d);
    }




}


class Calculate{
    List<Integer> list=null;

    Long start=null;
    Long end=null;
    Calculate(List<Integer> list){
        this.list=list;
    }


    void byTradition(){

        start=System.currentTimeMillis();
        for (Integer integer: list){
            double price=integer+.12*integer;
        }
        end=System.currentTimeMillis();
        System.out.println("tradition done,cost   "+(end-start));
    }

    void byLambda(){
        start=System.currentTimeMillis();
        list.stream().map((cost)->cost+.12*cost);
        end=System.currentTimeMillis();
        System.out.println("Lambda done   "+(end-start));
    }
}