package com.company;

class Th extends Thread{
    public Counter c;
    public Th(Counter c) {
        this.c = c;
    }
    public int getCount (){
        return c.count;
    }
    public void run(){
        for (int i=0; i<100; i++){
            c.count++;
        }
    }
}
