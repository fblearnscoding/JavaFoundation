package com.company;

public class ExceptionCatchAndFinallyDemo {
    //在捕获异常的代码快中程序返回的时机

    static int [] arr={1,2,3,4,5};

    public static void main(String[] args) {
        try{

        method1( arr);}

        catch (Exception e){
           /* try{
            System.out.println(arr[0]);}
            catch(Exception ex){
                e.printStackTrace();
            }*/
            e.printStackTrace();
            System.out.println(arr);
            e.getMessage();
        }
        finally{
            System.out.println("here  is finally block");
        }

    }

   static int method1(int  [] a){
        int b= a[1];

        return b;
    }
}
