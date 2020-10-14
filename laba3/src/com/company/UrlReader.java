package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class UrlReader {
    public static void Read(String url){
        url = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=\"Java\"";
        try {
            URL myUrl= new URL(url);
            URLConnection connect = myUrl.openConnection();
            HttpURLConnection connection = null;
            if(connect instanceof HttpURLConnection) {
                connection = (HttpURLConnection) connect;
            }else {
                System.out.println("Пожалуйста, введите HTTP URL.");
                return;
            }

            System.out.println(connect.getContent());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;

            while((current = in.readLine()) != null) {
                urlString += current;
            }
            System.out.println(urlString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
