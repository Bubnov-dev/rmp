package com.company;

public class ThNameSayer extends Thread{

    private String name;

   public ThNameSayer(String name) {
        this.name = name;
    }
    @Override
    public void run () {
        for (int i=0; i<100; i++) {
            System.out.println(name);
            try {
                this.wait();
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }
}
