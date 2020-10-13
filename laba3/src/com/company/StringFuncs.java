package com.company;

import static java.lang.Math.floor;

public class StringFuncs {
    public static String getMax(String [] str){
        String max = str[0];
        for (int i = 0; i< str.length; i++){
            if (max.length() < str[i].length()){
                max = str[i];
            }
        }
        return max;
    }

    public static boolean isAPalindrome (String str){
        char [] strC = str.toCharArray();
        int len = str.length();
        for (int i=0;i < floor(len/2); i++){
            if (strC[i]  != strC[len-i]){
                return false;
            }
        }
        return true;
    }

    public static String censor (String str, String cens){
        return str.replace(cens, "[вырезано цензурой");
    }

    public static int manyContains (String bigStr, String smallStr){
        int total = -1;
        int index = 0;

        while (index!= -1){
            index = bigStr.indexOf(smallStr, index);
            total ++;
        }
        return total;
    }

    public static String reverseWords(String str){
        String [] words = str.split(" ");
        String total ="";
        for (String word : words){
            word = new StringBuilder(word).reverse().toString();
            total.concat(word).concat(" ");
        }

        total = new StringBuilder(total).reverse().toString().replaceFirst(" ", "");
        total = new StringBuilder(total).reverse().toString();
        return total;

    }
    public static void Dictionary(String str){
        String [] words = str.split(" ");
        words = getArrayNomDuplicates(words);
        for (String word: words
             ) {
            System.out.println(word + " : " + manyContains(str, word));
        }
    }

    private static String[] getArrayNomDuplicates(String[] source) {
        int countRet = 0;
        for (int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[i] == source[j])
                    countRet++;
            }
        }
        String [] nonDup = new String [source.length - countRet];
        nonDup[0] = source[0];
        int nonDupIndexFill = 1;
        for (int i = 1; i < source.length; i++) {
            boolean flagNonDup = true;
            for (int j = 0; j <= nonDupIndexFill; j++) {
                if (source[i] == nonDup[j])
                    flagNonDup = false;
            }
            if (flagNonDup)
                nonDup[nonDupIndexFill++] = source[i];
        }
        return nonDup;
    }
}
