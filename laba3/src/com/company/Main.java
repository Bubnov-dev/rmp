package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("1 - Strings;\n2 - Threads;\n3 - .");
        choice = scan.nextInt();
        switch (choice){
            case 1:
                strTasks();
                break;
            case 2:
                threadsTasks();
                break;
            default: System.out.println("Error");
        }
        threadsTasks();
}
    static public void strTasks() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Max len;\n2 - is a palindrome?;\n3 - censure;\n4 - num of entry;\n5 - invert sentence;\n6 - dictionary");
        int choice = scan.nextInt();
        String str;
        switch (choice){
            case 1:
                String [] strs = new String[];
                System.out.println("input 3 strs");
                for (int i = 0; i < 3; i++) {
                    strs[i] = scan.nextLine();
                }
                System.out.println(StringFuncs.getMax(strs));
                break;

            case 2:
                System.out.println("input str");
                str = scan.nextLine();
                System.out.println(StringFuncs.isAPalindrome(str));
                break;
            case 3:
                System.out.println("input str");
                str = scan.nextLine();
                System.out.println("input rule");
                String rule = scan.nextLine();
                System.out.println(StringFuncs.censor(str, rule));

                break;
            case 4:
                System.out.println("input str");
                str = scan.nextLine();
                System.out.println("input str");
                String smallStr = scan.nextLine();
                System.out.println(StringFuncs.manyContains(str, smallStr));
                break;
            case 5:
                System.out.println("input str");
                str = scan.nextLine();
                System.out.println(StringFuncs.reverseWords(str));
                break;
            case 6:
                String content = new String(Files.readAllBytes(Paths.get("readMe.txt")), "UTF-8");
                StringFuncs.Dictionary(content);
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
