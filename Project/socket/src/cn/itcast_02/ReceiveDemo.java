package cn.itcast_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
//		1、创建接收端Socket对象
		DatagramSocket ds=new DatagramSocket(10086);
//		2、创建空的数据包（接收容器）
		byte[] bys=new byte[1024];
		int length=bys.length;
		DatagramPacket dp=new DatagramPacket(bys, length);
//		3、使用Socket对象的接收方法接收数据包
		ds.receive(dp);
//		4、解析数据包并打印数据包内容
		byte[] bys2=dp.getData();
		int length2=dp.getLength();
		String s=new String(bys2,0,length2);
		InetAddress address=dp.getAddress();
		String ip=address.getHostAddress();
		System.out.println(ip+"发送的数据是："+s);
//		5、释放资源
		ds.close();
	}
}
