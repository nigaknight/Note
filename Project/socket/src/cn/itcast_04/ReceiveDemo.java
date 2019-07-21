package cn.itcast_04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
//		1、创建接收端Socket对象
		DatagramSocket ds=new DatagramSocket(10086);
//		2、创建空的数据包（接收容器）
		while(true) {
			byte[] bys=new byte[1024];
			DatagramPacket dp=new DatagramPacket(bys, bys.length);
//			3、使用Socket对象的接收方法接收数据包
			ds.receive(dp);
//			4、解析数据包并打印数据包内容
			String s=new String(dp.getData(),0,dp.getLength());
			String ip=dp.getAddress().getHostAddress();
			System.out.println("from "+ip+" data is "+s);	
		}
	}
}
