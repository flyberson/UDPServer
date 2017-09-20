import java.io.*;
import java.net.*;

class UDPServer
{
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        byte[] yoyodata;
        while(true)
        {

            System.out.println(receiveData.length);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            yoyodata = new byte[receivePacket.getLength()];
            //receivePacket =
            serverSocket.receive(receivePacket);

            String sentence = new String( receivePacket.getData());
            //String sentence = new String( receivePacket.getData());


            System.out.println(receivePacket.getOffset()+receivePacket.getLength());
            System.out.println("RECEIVED: " + sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}