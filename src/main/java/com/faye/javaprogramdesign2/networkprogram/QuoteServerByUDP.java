package com.faye.javaprogramdesign2.networkprogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 * @Author Faye F F HE
 * @Date 2019/2/17 10:51
 */
public class QuoteServerByUDP {
    public static void main(String[] args) throws IOException{
        new QuoteServerThread().start();
    }
}

class QuoteServerThread extends Thread{
    protected DatagramSocket socket;
    protected BufferedReader in;
    protected boolean moreQuotes = true;
    public QuoteServerThread() throws IOException{
        this("QuoteServerThread");
    }
    public QuoteServerThread(String name) throws IOException{
        super(name);
        socket = new DatagramSocket(4445);
        in = new BufferedReader(new FileReader("pom.xml"));

    }

    @Override
    public void run() {
        while (moreQuotes){
            try {
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                System.out.println("received data" + new String(packet.getData()));
                String dString;
                if (in == null) dString = new Date().toString();
                else dString = getNextQuote();
                buf = dString.getBytes();

                // send the response to client by address and port
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
                System.out.println("send data: " + new String(packet.getData()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected String getNextQuote(){
        String returnValue = null;
        try {
            if ((returnValue = in.readLine()) == null){
                in.close();
                moreQuotes = false;
                returnValue = "no more return values, quote goodbye";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnValue;
    }

}
