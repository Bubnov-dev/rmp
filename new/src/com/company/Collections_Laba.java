package com.company;

import java.util.*;

public class Collections_Laba {

    public static List<String> NoDubs(List<String> list){
        return new ArrayList<String>(new HashSet<String> (list));
    }

    public static void timeCompare(){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        listOperations(list, random);
        listOperations(linkedList, random);
        listOperationsforA(random);
    }

    private static void listOperations (List<Integer> aList, Random random){
        System.out.println(aList.getClass());
        long start = System.currentTimeMillis();
        int tmp;
        for (int i = 0; i < 100000; i++) {
            tmp = random.nextInt();
            aList.add(tmp);
        }
        long middle = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            tmp = random.nextInt(100000);
            int a = aList.get(tmp);
        }
        long end = System.currentTimeMillis();
        System.out.println("to Middle: " + (middle-start) + "\nto end: " + (end-start)+ "\n\n");
    }

    private static void listOperationsforA (Random random){
        Integer [] aList = new Integer[100000];
        System.out.println(aList.getClass());
        long start = System.currentTimeMillis();
        int tmp;
        for (int i = 0; i < 100000; i++) {
            tmp = random.nextInt();
            aList[i] = (tmp);
        }
        long middle = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            tmp = random.nextInt(100000);
            int a = aList[tmp];
        }
        long end = System.currentTimeMillis();
        System.out.println("to Middle: " + (middle-start) + "\nto end: " + (end-start)+ "\n\n");
    }

    public static void getPoints(){
        Map<User, Integer> userMap = new HashMap<>();
        List <User> users = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sb.append((char)(random.nextInt(100)+500));
            }
            System.out.println(sb.toString());
            users.add(new User(sb.toString()));
            userMap.put(users.get(i), random.nextInt());
        }
        for (User user: users
             ) {
            System.out.println(user);
            System.out.println(userMap.get(user));
        }
    }

    public static Map <Object, Integer> getSub(List<Object> list){
        Map <Object, Integer> subs = new HashMap<>();
        for (Object o: list
             ) {
            Object oTmp = o;
            Integer nTmp = Collections.frequency(list, oTmp);
            subs.put(oTmp, nTmp);
        }
        return subs;
    }


    public static List<String> reverseMap (Map map){
        List<String> list = new ArrayList<>();
        Set<String> keys = map.keySet();
        for (String key: keys
             ) {
            String tmp = map.get(key) +  " - " + key;
            list.add(tmp);
        }

        return list;
    }

}


