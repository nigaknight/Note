package cn.itcast_06;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TCP��������
// A���������ն�Socket����
// B�������ͻ������ݣ�����һ��Socket����
// C����ȡ����������������
// D���ͷ���Դ
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(8888);
		Socket s=ss.accept();
		InputStream is=s.getInputStream();
		byte[] bys=new byte[1024];
		int len=is.read(bys);
		String str=new String(bys,0,len);
		System.out.println(str);
		s.close();
	}
 }
