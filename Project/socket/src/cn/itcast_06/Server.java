package cn.itcast_06;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TCP接收数据
// A、创建接收端Socket对象
// B、监听客户端数据，返回一个Socket对象
// C、获取输入流，接收数据
// D、释放资源
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
