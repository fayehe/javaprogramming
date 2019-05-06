package com.faye.javaprogramdesign2.networkprogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Faye F F HE
 * @Date 2019/1/27 22:31
 */
public class TalkServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8088);

            socket = server.accept();
            String line;
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client : " + is.readLine());
            line = in.readLine();
            while (!line.equalsIgnoreCase("bye")) {
                os.println(line);
                os.flush();
                System.out.println("Server : " + line);
                System.out.println("Client : " + is.readLine());
                line = in.readLine();
            }

            in.close();
            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
