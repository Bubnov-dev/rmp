
package com.company;

import java.util.*;

public class Collections_laba {
    public Collections_laba() {
    }

    public static List<String> NoDubs(List<String> list) {
        return new ArrayList(new HashSet(list));
    }

    public static void timeCompare() {
        LinkedList<Integer> linkedList = new LinkedList();
        List<Integer> list = new ArrayList();
        Random random = new Random();
        listOperations(list, random);
        listOperations(linkedList, random);
        listOperationsforA(random);
    }

    private static void listOperations(List<Integer> aList, Random random) {
        System.out.println(aList.getClass());
        long start = System.currentTimeMillis();

        int tmp;
        for(int i = 0; i < 100000; ++i) {
            tmp = random.nextInt();
            aList.add(tmp);
        }

        long middle = System.currentTimeMillis();

        for(int i = 0; i < 100000; ++i) {
            tmp = random.nextInt(100000);
            int var8 = (Integer)aList.get(tmp);
        }

        long end = System.currentTimeMillis();
        System.out.println("to Middle: " + (middle - start) + "\nto end: " + (end - start) + "\n\n");
    }

    private static void listOperationsforA(Random random) {
        Integer[] aList = new Integer[100000];
        System.out.println(aList.getClass());
        long start = System.currentTimeMillis();

        int tmp;
        for(int i = 0; i < 100000; ++i) {
            tmp = random.nextInt();
            aList[i] = tmp;
        }

        long middle = System.currentTimeMillis();

        for(int i = 0; i < 100000; ++i) {
            tmp = random.nextInt(100000);
            int var8 = aList[tmp];
        }

        long end = System.currentTimeMillis();
        System.out.println("to Middle: " + (middle - start) + "\nto end: " + (end - start) + "\n\n");
    }

    public static void getPoints() {
        Map<User, Integer> userMap = new HashMap();
        List<User> users = new ArrayList();
        Random random = new Random();

        for(int i = 0; i < 10; ++i) {
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < 10; ++j) {
                sb.append((char)(random.nextInt(100) + 500));
            }

            System.out.println(sb.toString());
            users.add(new User(sb.toString()));
            userMap.put((User)users.get(i), random.nextInt());
        }

        Iterator var6 = users.iterator();

        while(var6.hasNext()) {
            User user = (User)var6.next();
            System.out.println(user);
            System.out.println(userMap.get(user));
        }

    }

    public static Map<Object, Integer> getSub(List<Object> list) {
        Map<Object, Integer> subs = new HashMap();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Object o = var2.next();
            Integer nTmp = Collections.frequency(list, o);
            subs.put(o, nTmp);
        }

        return subs;
    }

    public static List<String> reverseMap(Map map) {
        List<String> list = new ArrayList();
        Set<String> keys = map.keySet();
        Iterator var3 = keys.iterator();

        while(var3.hasNext()) {
            String key = (String)var3.next();
            Object var10000 = map.get(key);
            String tmp = var10000 + " - " + key;
            list.add(tmp);
        }

        return list;
    }

    public static void Dictionary(String str){
        String [] words = str.split(" ");
        List<Object> wordList = Arrays.asList(str.split(" "));
        System.out.println(getSub(wordList));
    }
}
