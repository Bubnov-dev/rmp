package com.company;



public class Main {

    public static void main(String[] args) {
	    MyVector[] arr = new MyVector[10];
	    arr = MyVector.getRandArr(10);

        for(int i=0; i< 10; i++){
            System.out.println( arr[i].toString());
            System.out.println(arr[i].getLen());
        }

        System.out.println("scalar: " + MyVector.scalar(arr[0], arr[1]));
        System.out.println("vector mult: " + MyVector.vectorMult(arr[0], arr[1]));
        System.out.println("getCos: " + MyVector.getCos(arr[0], arr[1]));
        System.out.println("minus: " + MyVector.minus(arr[0], arr[1]));
        System.out.println("plus: " + MyVector.plus(arr[0], arr[1]));



    }
}
