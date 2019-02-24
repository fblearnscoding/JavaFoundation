package com.company;

public class InnerAndOuter {

    class Inner{}

   static void a(){
        //new Inner();
    }
    void b(){
        new Inner();
    }

    public static void main(String[] args) {
        //new Inner();
    }
}
