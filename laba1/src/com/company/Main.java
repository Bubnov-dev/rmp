package com.company;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("task1:");
        getMMA(10);
        System.out.println("task2: input N and K");
        Scanner in = new Scanner(System.in);
        Double N = in.nextDouble();
        Double K = in.nextDouble();
        getSentence(5.0,5.0);
        System.out.println("task3:");
        Double [] arr = getRandArr(10);
        Arrays.sort(arr);
        for (int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("task4:");
        simples(1, 100);
        System.out.println("task5:");
        System.out.println(Fib(10));
    }

    static Double[] getRandArr(int size){
        Double [] arr = new Double[size];

        for(int i=0; i<size; i++){
            Double tmp = Math.random()*2;
            arr[i]= tmp;
        }
        return arr;
    }
    static void getMMA(int size){
        Double [] arr = getRandArr(size);
        Arrays.sort(arr);
        System.out.println("max: " + arr[size-1]+ "\nmin: " +arr[0] + "\navg: " + avg(arr));

    }

    static Double avg(Double[] arr){
        Double total = 0.0;
        for (int i=0; i<arr.length; i++){
            total+= arr[i];
        }
        return (total/arr.length);
    }

    static void getSentence(Double N, Double K){
        Double total = 0.0;
        int fin = K.intValue();
        for(int i=1; i<=K; i++){
            Double tmp = Double.valueOf(i);
            total += Math.pow(tmp, K);
        }
        System.out.println("total of sentence: " + total);
    }


    static void simples(int first, int second){
        for (int i = first; i<second; i++){
            if (checkSimple(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static boolean checkSimple(int i){
        if (i<=1)
            return false;
        else if (i <=3)
            return true;
        else if (i%2==0 || i %3 ==0)
            return false;
        int n = 5;
        while (n*n <=i){
            if (i % n ==0 || i % (n+2) == 0)
                return false;
            n=n+6;
        }
        return true;
    }

    static int Fib(int N){
        Double total=1.0;
        if (N==0) return 1;
        for (int i = 1; i<N-1; i++){
            total = Math.ceil(total*1.5);
        }

        return (total.intValue());
    }


}
