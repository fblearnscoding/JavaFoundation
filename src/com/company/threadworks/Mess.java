package com.company.threadworks;

public class Mess {
    public static void main(String[] args) {
        new TomA().tomb();
    }

    static class TomA{
        void tomb(){
            notify();
        }
    }
}
