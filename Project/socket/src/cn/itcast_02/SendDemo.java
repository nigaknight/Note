package cn.itcast_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//1���������Ͷ�Socket����
		DatagramSocket ds=new DatagramSocket();
		//2���������ݣ��������ݴ��
		//DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
		byte[] bs="ʹ��Socket����UDP���ݰ�".getBytes();
		int length=bs.length;
		InetAddress ip=InetAddress.getByName("DESKTOP-E74M56D");
		int port=10086;
		DatagramPacket dp=new DatagramPacket(bs,length,ip,port);
		//3������Socket�����send�����������ݰ�
		ds.send(dp);
		//4���ͷ���Դ
		ds.close();
	}
}
