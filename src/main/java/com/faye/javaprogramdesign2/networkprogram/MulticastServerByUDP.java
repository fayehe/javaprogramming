package com.faye.javaprogramdesign2.networkprogram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

/**
 * @Author Faye F F HE
 * @Date 2019/2/17 14:25
 */
public class MulticastServerByUDP {
    public static void main(String[] args) throws IOException{
        new MulticastServerThread().start();
    }
}

class MulticastServerThread extends QuoteServerThread{
    private long FIVE_SECONDS = 5000;
    MulticastServerThread() throws IOException{
        super("MulticastServerThread");
    }

    @Override
    public void run() {
        while (moreQuotes){
            try {
                byte[] buf = new byte[256];
                String dString;
                if (in == null) dString = new Date().toString();
                else dString = getNextQuote();
                buf = dString.getBytes();

                InetAddress address = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4446);
                socket.send(packet);
                System.out.println("send data: " + new String(packet.getData()));

                //sleep for a while
                sleep((long)(Math.random()*FIVE_SECONDS));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
