package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        Collections_laba.Dictionary("one two two three three three");
        List<String> list = new ArrayList();
        list.add("str1");
        list.add("str2");
        list.add("str1");
        System.out.println(Collections_laba.NoDubs(list));
        Collections_laba.timeCompare();
        Collections_laba.getPoints();
        int[][] arr = new int[10][2];

        for(int i = 0; i < 10; ++i) {
            arr[i][0] = i;
            arr[i][1] = -i;
        }

        ArrIterator ai = new ArrIterator(arr);

        while(ai.hasNext()) {
            int[] tmp = (int[])ai.next();
            System.out.println("[" + tmp[0] + " | " + tmp[1] + "]");
        }

        List<Object> list1 = new ArrayList();
        User user0 = new User("sasha");
        User user1 = new User("igor");
        User user2 = new User("dima");
        list1.add(user0);
        list1.add(user1);
        list1.add(user2);
        list1.add(user0);
        System.out.println(Collections_laba.getSub(list1));
        Map<String, Integer> map = new HashMap();
        map.put("first", 1);
        map.put("Second", 2);
        map.put("third", 3);
        System.out.println(Collections_laba.reverseMap(map).toString());
    }
}
