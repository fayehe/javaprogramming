package com.faye.javaprogramdesign2.networkprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author Faye F F HE
 * @Date 2019/1/27 22:19
 */
public class TalkClient2 {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter os = null;
        BufferedReader is = null;
        try {
            socket = new Socket("127.0.0.1", 8088);
            in = new BufferedReader(new InputStreamReader(System.in));
            os = new PrintWriter(socket.getOutputStream());
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readLine = in.readLine();
            while (!readLine.equalsIgnoreCase("bye")){
                os.println(readLine);
                os.flush(); //强制发送出去
                System.out.println("Client2 ：" + readLine);
                System.out.println("Server1-2 : " + is.readLine());
                readLine = in.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                os.close();
                is.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
