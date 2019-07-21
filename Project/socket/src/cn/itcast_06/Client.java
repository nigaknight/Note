package cn.itcast_06;
// TCP发送数据
// A、创建发送端Socket对象 如果这一步成功，则表明已成功建立连接
// B、获取输出流
// C、释放资源，写资源

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
//		Socket s=new Socket(InetAddress.getByName("172.16.3.251"),8888);
		Socket s=new Socket("169.254.151.55",8888);
		OutputStream os=s.getOutputStream();
		os.write("使用Socket发送TCP包".getBytes());
		s.close();
	}
	
}
