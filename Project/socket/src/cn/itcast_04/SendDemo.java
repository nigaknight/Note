package cn.itcast_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//1���������Ͷ�Socket����
		DatagramSocket ds=new DatagramSocket();
		//��װ����¼������
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=br.readLine())!=null) {
			if("886".equals(line)) {
				break;
			}
			//2���������ݣ��������ݴ��
			//DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
			byte[] bs=line.getBytes();
			DatagramPacket dp=new DatagramPacket(bs,bs.length,
					InetAddress.getByName("10.192.36.118"),10086);
			//3������Socket�����send�����������ݰ�
			ds.send(dp);	
		}
		//4���ͷ���Դ
		ds.close();
	}
}
