package com.company;

public class SerializeDemo  {
    //实现两种方式的深度克隆

    public static void main(String[] args) {

        CloneFoo1 foo1= new CloneFoo1();
        CloneFoo1 foo2;

        try{
            foo2 = (CloneFoo1) foo1.clone();
            System.out.println("compare:"+(foo1==foo2));
            System.out.println(foo1.a==foo2.a);
            System.out.println(foo1.foo2==foo2.foo2);
            System.out.println(foo1.foo2.figureNum==foo2.foo2.figureNum);

        } catch(Exception e){

        }
    }




}
class CloneFoo1 implements Cloneable{

    int a=3;

    CloneFoo2 foo2=new CloneFoo2();

    @Override
    protected Object clone() throws CloneNotSupportedException {

        CloneFoo1 foo1=(CloneFoo1) super.clone();
        foo1.foo2=(CloneFoo2) foo2.clone();
        return foo1;

    }
}

class CloneFoo2 implements Cloneable{

    public int figureNum=4;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}




