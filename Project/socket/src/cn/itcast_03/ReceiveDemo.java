package cn.itcast_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//�Է��ͺͽ������ݵĴ�����Ż�
public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
//		1���������ն�Socket����
		DatagramSocket ds=new DatagramSocket(10086);
//		2�������յ����ݰ�������������
		byte[] bys=new byte[1024];
		DatagramPacket dp=new DatagramPacket(bys, bys.length);
//		3��ʹ��Socket����Ľ��շ����������ݰ�
		ds.receive(dp);
//		4���������ݰ�����ӡ���ݰ�����

		String s=new String(dp.getData(),0,dp.getLength());
		String ip=dp.getAddress().getHostAddress();
		System.out.println("from "+ip+" data is "+s);
//		5���ͷ���Դ
		ds.close();
	}
}
