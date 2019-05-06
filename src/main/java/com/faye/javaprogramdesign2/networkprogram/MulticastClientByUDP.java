package com.faye.javaprogramdesign2.networkprogram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author Faye F F HE
 * @Date 2019/2/17 14:17
 */
public class MulticastClientByUDP {
    public static void main(String[] args) throws IOException{
        MulticastSocket multicastSocket = new MulticastSocket(4446);
        InetAddress address = InetAddress.getByName("230.0.0.1");
        multicastSocket.joinGroup(address);
        DatagramPacket packet;
        for (int i=0; i<5; i++){
            byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);
            multicastSocket.receive(packet);
            System.out.println("received data " + (i + 1) + " : " + new String(packet.getData()));

        }

        multicastSocket.leaveGroup(address);
        multicastSocket.close();
    }
}
