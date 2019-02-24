package com.company;

public class AbstraClassAndInterfaceDemo {
    public static void main(String[] args) {
        new jolt(){
            @Override
            public void method1() {

            }
        };

        new Aclass(){
            @Override
            void method1() {

            }

            @Override
            void method2() {

            }
        };

    }
}

interface jolt{
    abstract void method1(
    );
    int a =1;

}
abstract class Aclass {

    void method1(){
        System.out.println("this is abstractClass,i am concretMethod1");
    }

    abstract void method2();

    int a=3;
}
