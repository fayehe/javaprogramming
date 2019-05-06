package com.faye.javaprogramdesign2.networkprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author Faye F F HE
 * @Date 2019/1/27 21:46
 */
public class GetAndPost {

    public static String sendByGet(String url, String param){
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url + "?" + param);
            URLConnection connection = realUrl.openConnection();
            //设置通用的url属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.connect(); //建立实际的连接

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                result += line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static String sendByPost(String url, String param){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setDoOutput(true); //允许输出流
            out = new PrintWriter(connection.getOutputStream());
            out.print(param); //发送请求参数
            out.flush(); //flush 输出流的缓冲（强制发出）

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                result += line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
