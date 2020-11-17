package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int choice=0;
        while (choice!=-1) {
            System.out.println("-1 - exit;\n1 - Strings;\n2 - Threads;\n3 - url.");
            Scanner scan = new Scanner(System.in);
            System.out.println();
            if (scan.hasNext())// I DONT UNDERSTAND
                choice = scan.nextInt();
            else choice = -1;
            switch (choice) {
                case 1:
                    strTasks();
                    break;
                case 2:
                    threadsTasks();
                    break;
                case 3:
                    UrlReader.Read("");
                default:
                    System.out.println("Error");
            }
            scan.close();
        }
    }
    static public void strTasks(){
        Scanner scan = new Scanner(System.in);
        //System.out.println("1 - Max len;\n2 - is a palindrome?;\n3 - censure;\n4 - num of entry;\n5 - invert sentence;\n6 - dictionary");
        int choice = 1;
        scan.close();
        String [] str = new String[3];
        str[0] = "mama mila ramu";
        str[1] = "mila";
        str[2] = "qwertytrewq";
        for (int j = 1; j < 7; j++) {

            System.out.println("_____________________________________________\n\n");
            choice = j;
            switch (choice) {
                case 1:
                    scan = new Scanner(System.in);
                    System.out.println("input 3 strs");
                    /*for (int i = 0; i < 3; i++) {
                        str[i] = scan.nextLine();
                    }*/
                    System.out.println("strs: " + str[0] + " | " + str[1] + " | " + str[2] + "|");
                    System.out.println(StringFuncs.getMax(str));
                    scan.close();
                    break;

                case 2:
                    System.out.println("input str");
                    scan = new Scanner(System.in);
                    System.out.println(StringFuncs.isAPalindrome(str[2]));
                    scan.close();
                    break;
                case 3:
                    scan = new Scanner(System.in);
                    System.out.println("input str");
                    System.out.println("input rule");
                    System.out.println("with cens: " + StringFuncs.censor(str[0], str[1]));

                    scan.close();
                    break;
                case 4:
                    scan = new Scanner(System.in);
                    System.out.println("input str");
                    System.out.println("input str");
                    System.out.println(StringFuncs.manyContains(str[0], str[1]));
                    scan.close();
                    break;
                case 5:
                    scan = new Scanner(System.in);
                    System.out.println("input str");
                    System.out.println(StringFuncs.reverseWords(str[0]));
                    scan.close();
                    break;
                case 6:
                    scan = new Scanner(System.in);
                    String content;
                    try {
                        content = new String(Files.readAllBytes(Paths.get("C:/readMe.txt")), "UTF-8");
                        System.out.println("content: " + content);
                        StringFuncs.Dictionary(content);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    scan.close();
                    break;
            }
        }
    }

    static public void threadsTasks (){
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - ten threads 0-100;\n2 - inc by few threads;\n 3 - say my name - synchronize.");
        choice = scan.nextInt();
        switch (choice){
            case 1:
                tenThs();
                break;
            case 2:
                multInc();
                break;
            case 3:
                syncNames();
                break;

            default: System.out.println("Error");
            break;
        }

    }

    static void tenThs () {
        Threads [] ths = new Threads[10];
        for(int i=0; i<10;i++){
            ths[i]=new Threads();
        }
        for (Threads th: ths
        ) {
            System.out.println(th.getState());
            th.start();
            System.out.println(th.getState());
        }
    }

    static void multInc(){
        int size = 100;
        Counter i = new Counter(0);
        Th [] ths = new Th [size];

        for (int j = 0; j < size; j++) {
            ths[j] = new Th(i);
            ths[j].start();
        }
       boolean running = true;
        while (running){
            running = false;
            for (int j = 0; j < size; j++) {
                if (ths[j].getState() != Thread.State.TERMINATED) running = true;
            }
        }
        System.out.println("in source: " + i.count);

    }

    static void syncNames(){
        Integer sync = 0;
        ThNameSayer thns0 = new ThNameSayer("Sanya");
        ThNameSayer thns1 = new ThNameSayer("Igor");

        thns0.start();
        thns1.start();
        while (!(thns1.getState() == Thread.State.TERMINATED && thns0.getState() == Thread.State.TERMINATED)) {
            if (sync == 0) {
                //thns0.wait();
                try{
                    thns1.notify();

                } catch (Exception e) {
                    //e.printStackTrace();
                }
                sync++;
            } else {
                try {
                    thns0.notify();
                }
                catch (Exception e) {
                    //e.printStackTrace();
                }
                //thns1.wait();
                sync--;
            }

        }
    }

}
