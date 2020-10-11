package com.company;



public class Main {

    public static void main(String[] args) {
	    MyVector[] arr = new MyVector[10];
	    arr = MyVector.getRandArr(10);

        for(int i=0; i< 10; i++){
            System.out.println( arr[i].toString());
        }


    }
}
