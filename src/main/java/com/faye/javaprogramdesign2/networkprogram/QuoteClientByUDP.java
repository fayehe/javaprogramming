package com.faye.javaprogramdesign2.networkprogram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author Faye F F HE
 * @Date 2019/2/17 10:31
 */
public class QuoteClientByUDP {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        byte[] receiveBuf = new byte[256];
        byte[] sendBuf = "test send data".getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, address, 4445);
        socket.send(packet);// 发送数据报 - 发送邮件
        System.out.println("sent data: " + new String(packet.getData()));

        //接收数据报 - 接收邮件
        packet = new DatagramPacket(receiveBuf, receiveBuf.length);
        socket.receive(packet);
        System.out.println("receive quote:" + new String(packet.getData()));
        socket.close();
    }
}
