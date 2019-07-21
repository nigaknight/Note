package cn.itcast_01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
//		public static InetAddress getByName(String host) 获得IP地址对象
		InetAddress address=InetAddress.getByName("DESKTOP-E74M56D");
		String host=address.getHostName();
		String ip=address.getHostAddress();
		System.out.println(host+"----"+ip);
	}
}
