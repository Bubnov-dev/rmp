package com.company;

public class Threads extends Thread{

    @Override
    public void run(){
        for(int i=0; i< 100; i++){
            System.out.println(i);
        }
    }
}
