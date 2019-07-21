package cn.itcast_05;

import java.net.DatagramSocket;
import java.net.SocketException;


public class ChatRoom {
	public static void main(String[] args) throws SocketException {
		DatagramSocket dsSend=new DatagramSocket();
		DatagramSocket dsReceive=new DatagramSocket(10086);
		ThreadSend ts=new ThreadSend(dsSend);
		ThreadReceive tr=new ThreadReceive(dsReceive);
		Thread t1=new Thread(ts);
		Thread t2=new Thread(tr);
		t1.start();
		t2.start();
	}
}
