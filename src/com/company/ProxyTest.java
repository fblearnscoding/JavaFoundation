package com.company;

import com.sun.deploy.net.proxy.ProxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyTest {


    public static void main(String[] args) {

        List<String>  list=new ArrayList<>();
        list.add("original added1");
        List<String> instance= (List )  Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //此时卫为什么还要传list呢？这样有静态代理之嫌疑。
               return method.invoke(list,args);
            }
        });

        instance.add("instance added1");
        System.out.println(instance);
    }
}
