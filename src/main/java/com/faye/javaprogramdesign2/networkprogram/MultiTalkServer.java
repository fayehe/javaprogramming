package com.faye.javaprogramdesign2.networkprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Faye F F HE
 * @Date 2019/1/27 22:31
 */
public class MultiTalkServer {
    static int clientNum = 0;
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(8088);
            while (listening){
                new ServerThread(serverSocket.accept(), clientNum).start();
                clientNum++;
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ServerThread extends Thread{
    Socket socket;
    int clientNumber;
    ServerThread(Socket socket, int number){
        this.socket = socket;
        this.clientNumber = number + 1;
    }

    @Override
    public void run() {
        try {
            String line;
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client  " + clientNumber + " : " + is.readLine());
            line = in.readLine();
            while (!line.equalsIgnoreCase("bye")) {
                os.println(line);
                os.flush();
                System.out.println("Muti-Server to client " + clientNumber + " : " + line);
                System.out.println("Client " + clientNumber + " : " + is.readLine());
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