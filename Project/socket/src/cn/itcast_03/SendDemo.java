package cn.itcast_03;

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
		byte[] bs="UDP,�����ˣ�".getBytes();
		DatagramPacket dp=new DatagramPacket(bs,bs.length,
				InetAddress.getByName("172.16.3.251"),10086);
		//3������Socket�����send�����������ݰ�
		ds.send(dp);
		//4���ͷ���Դ
		ds.close();
	}
}
