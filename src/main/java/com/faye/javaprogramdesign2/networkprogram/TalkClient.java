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
public class TalkClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8088);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readLine = in.readLine();
            while (!readLine.equalsIgnoreCase("bye")){
                os.println(readLine);
                os.flush(); //强制发送出去
                System.out.println("Client ：" + readLine);
                System.out.println("Server : " + is.readLine());
                readLine = in.readLine();
            }

            in.close();
            os.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
