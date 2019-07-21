package cn.itcast_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//1、创建发送端Socket对象
		DatagramSocket ds=new DatagramSocket();
		//封装键盘录入数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=br.readLine())!=null) {
			if("886".equals(line)) {
				break;
			}
			//2、创建数据，并将数据打包
			//DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
			byte[] bs=line.getBytes();
			DatagramPacket dp=new DatagramPacket(bs,bs.length,
					InetAddress.getByName("10.192.36.118"),10086);
			//3、调用Socket对象的send方法发送数据包
			ds.send(dp);	
		}
		//4、释放资源
		ds.close();
	}
}
