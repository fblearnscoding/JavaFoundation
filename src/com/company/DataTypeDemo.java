package com.company;

public class DataTypeDemo {

    public static void main(String[] args) {
       // method1();
        method2();

    }


    //验证java对于Integer类型且数值在-128-127的优化
    static void method1(){

        Integer a=100,b=100,c=128,d=128,e=129,f=129;

         System.out.println("Integer before 128:"+(a==b));
         System.out.println("Integer equals 128"+(c==d));
        System.out.println("Integer after 128"+(e==f));
     }

     //验证Long是否对于数值在-128-127进行优化

    static void method2(){

        Long a=100L,b=100L,c=128L,d=128L,e=129L,f=129L;

        System.out.println("Long before 128:"+(a==b));
        System.out.println("Long equals 128"+(c==d));
        System.out.println("Long after 128"+(e==f));
    }
}
