package com.company;

public class Foo implements A,B{
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    @Override
    public void a() {
        System.out.println("this is method 'a'");
    }

    @Override
    public void b() {
        System.out.println("this is method 'b'");
    }
}
