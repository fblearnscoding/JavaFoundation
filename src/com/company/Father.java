package com.company;

public class Father {
   /* public static void main(String[] args) {
        System.out.println("i am the father ,main");
    }*/

    //
    protected void method1(){
        System.out.println("i am the father ,method1");
    }
    protected void method2(){
        System.out.println("i am the father ,method2");
    }

    static void methodStatic(){
        System.out.println("i am thr father ,methodStatic");
    }

}



class Son extends Father{
    /*public static void main(String[] args) {

        System.out.println("i am the son ,main");
    }*/

    @Override
    protected void method1() {
       super.method1();
        //System.out.println("i am the son ,method1");
    }

    @Override
    protected void method2() {
        super.method2();
       // System.out.println("i am the son ,method2");
    }

    /* void methodSon1(){
        System.out.println("i am the son ,methodSon1");
    }*/

    static void methodStatic(){
        System.out.println("i am the Son,methodStatic");
    }
}

class Daughter extends Son{


}

class Demo{
    public static void main(String[] args) {

        new Father().method1();
        new Son().method1();
        //new Son().methodSon1();

        Son.methodStatic();

       // Son transFromFather =  (Son)new Father();




    }

}
