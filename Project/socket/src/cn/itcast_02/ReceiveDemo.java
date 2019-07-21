package cn.itcast_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
//		1���������ն�Socket����
		DatagramSocket ds=new DatagramSocket(10086);
//		2�������յ����ݰ�������������
		byte[] bys=new byte[1024];
		int length=bys.length;
		DatagramPacket dp=new DatagramPacket(bys, length);
//		3��ʹ��Socket����Ľ��շ����������ݰ�
		ds.receive(dp);
//		4���������ݰ�����ӡ���ݰ�����
		byte[] bys2=dp.getData();
		int length2=dp.getLength();
		String s=new String(bys2,0,length2);
		InetAddress address=dp.getAddress();
		String ip=address.getHostAddress();
		System.out.println(ip+"���͵������ǣ�"+s);
//		5���ͷ���Դ
		ds.close();
	}
}
