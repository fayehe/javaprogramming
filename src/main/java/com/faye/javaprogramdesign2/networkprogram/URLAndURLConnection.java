package com.faye.javaprogramdesign2.networkprogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author Faye F F HE
 * @Date 2019/1/27 20:59
 */
public class URLAndURLConnection {
    public static void main(String[] args) {
//        getSinaFromURL();
        getBaiduFromURLConnection();
    }

    public static void getSinaFromURL(){
        try {
            URL url = new URL("https://www.sina.com.cn/");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());

            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getBaiduFromURLConnection(){
        try {
            URL url = new URL("https://www.baidu.com/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
