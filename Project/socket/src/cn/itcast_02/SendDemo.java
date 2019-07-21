package cn.itcast_02;

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
		byte[] bs="使用Socket发送UDP数据包".getBytes();
		int length=bs.length;
		InetAddress ip=InetAddress.getByName("DESKTOP-E74M56D");
		int port=10086;
		DatagramPacket dp=new DatagramPacket(bs,length,ip,port);
		//3、调用Socket对象的send方法发送数据包
		ds.send(dp);
		//4、释放资源
		ds.close();
	}
}
