package com.company;

import java.util.Arrays;

public class WEBQuery {
    public SearchInfo searchInfo;
    public Info [] search;

    @Override
    public String toString() {
        return "WEBQuery{" +
                "search=" + Arrays.toString(search) +
                '}';
    }
}

class SearchInfo{
    public int searchInfo;
}

class Search{
    Info [] info;
}

class Info{
    public int ns;
    public String title;
    public int pageid;
    public int size;
    public int wordcount;
    public String snippet;
    public String timestamp;

    @Override
    public String toString() {
        return "" +
                "title: " + title + "\n" +
                ", text: " + snippet + "\n\n"
                ;
    }
}


