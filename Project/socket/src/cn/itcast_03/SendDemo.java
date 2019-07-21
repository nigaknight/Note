package cn.itcast_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//1、创建发送端Socket对象
		DatagramSocket ds=new DatagramSocket();
		//2、创建数据，并将数据打包
		//DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
		byte[] bs="UDP,我来了！".getBytes();
		DatagramPacket dp=new DatagramPacket(bs,bs.length,
				InetAddress.getByName("172.16.3.251"),10086);
		//3、调用Socket对象的send方法发送数据包
		ds.send(dp);
		//4、释放资源
		ds.close();
	}
}
