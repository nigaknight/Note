package cn.itcast_06;
// TCP��������
// A���������Ͷ�Socket���� �����һ���ɹ���������ѳɹ���������
// B����ȡ�����
// C���ͷ���Դ��д��Դ

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
//		Socket s=new Socket(InetAddress.getByName("172.16.3.251"),8888);
		Socket s=new Socket("169.254.151.55",8888);
		OutputStream os=s.getOutputStream();
		os.write("ʹ��Socket����TCP��".getBytes());
		s.close();
	}
	
}
