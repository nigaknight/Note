package cn.itcast_05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ThreadReceive implements Runnable {
	DatagramSocket ds;

	public ThreadReceive(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {
				byte[] bys = new byte[1024];
				DatagramPacket dp = new DatagramPacket(bys, bys.length);
//			3��ʹ��Socket����Ľ��շ����������ݰ�
				ds.receive(dp);
//			4���������ݰ�����ӡ���ݰ�����
				String s = new String(dp.getData(), 0, dp.getLength());
				String ip = dp.getAddress().getHostAddress();
				System.out.println("from " + ip + " data is " + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
