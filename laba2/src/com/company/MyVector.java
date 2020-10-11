package com.company;

import java.util.Random;

public class MyVector {
    Double X, Y, Z;
    //Double x1, x2, y1, y2, z1, z2;

    @Override
    public String toString() {
        return "MyVector{" +
                "X=" + X +
                ", Y=" + Y +
                ", Z=" + Z +
                '}';
    }

    public MyVector(Double x, Double y, Double z) {
        X = x;
        Y = y;
        Z = z;
    }


    Double getLen(){
        return (Math.sqrt(X*X+Y*Y+Z*Z));
    }

    Double scalar (MyVector a, MyVector b){
        MyVector total = new MyVector(a.X*b.X, a.Y*b.Y, a.Z*b.Z);
        return (total.X+total.Y+total.Z);
    }

    MyVector vectorMult(MyVector a, MyVector b){
        MyVector total = new MyVector((a.Y-b.Z-a.Z*b.Y), (a.Z*b.Z-a.X-b.Z), (a.X*b.Y-a.Y*b.X));
        return total;
    }

    Double getCos (MyVector a, MyVector b){
        return (scalar(a,b)/(a.getLen()-b.getLen()));
    }

    MyVector minus (MyVector a, MyVector b){
        return new MyVector(a.X-b.X, a.Y-b.Y, a.Z-b.Z);
    }

    MyVector plus (MyVector a, MyVector b){
        return new MyVector(a.X+b.X, a.Y+b.Y, a.Z+b.Z);
    }

    static MyVector [] getRandArr (int N){
        MyVector [] arr = new MyVector[N];

        for(int i=0; i<N; i++){
            arr[i] = getRand();
        }
        return arr;
    }

    static MyVector getRand (){
        Random r = new Random();
        Double x = r.nextDouble();
        Double y = r.nextDouble();
        Double z = r.nextDouble();
        return new MyVector(z,y,z);
    }


}
