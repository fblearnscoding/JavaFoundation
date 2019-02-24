package com.company;

import java.io.*;

public class SerializeWithIODemo {

    public static void main(String[] args) {
        Book b= new Book(9.45,"新华字典",132l);
        System.out.println(b);
        Book newb = null;

        try {
            newb = SerializeUtil.doSerialize(b);
            System.out.println(newb);
            System.out.println(b==newb);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}


class SerializeUtil {
/*
    public SerializeWrapper() throws Exception{

    }
*/
    public  static <T extends Serializable > T doSerialize(T in ) throws Exception {

        ByteArrayOutputStream baos =new ByteArrayOutputStream();
        ObjectOutputStream oos =new ObjectOutputStream(baos);
        oos.writeObject(in);
        ByteArrayInputStream bais =new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois =new ObjectInputStream(bais);
        return (T)ois.readObject();
    }
}



class Book implements Serializable {

    private static final long serialNum= 1l;

    private double price;
    private String name;
    private long pressCode;

    public Book (double price, String name, long pressCode) {
        this.price = price;
        this.name = name;
        this.pressCode = pressCode;
    }

    public long getSerialNum() {
        return serialNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPressCode() {
        return pressCode;
    }

    public void setPressCode(long pressCode) {
        this.pressCode = pressCode;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", pressCode=" + pressCode +
                '}';
    }
}
