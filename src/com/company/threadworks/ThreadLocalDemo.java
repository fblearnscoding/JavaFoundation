package com.company.threadworks;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal=new ThreadLocal<>();
        stringThreadLocal.set("123");
        System.out.println(stringThreadLocal.get());
        stringThreadLocal.set("456");
        System.out.println(stringThreadLocal.get());
    }
}
