package io;

import java.io.*;

/**
 * @author nigaknight
 * @time 2019/10/22
 * 先向文件中写入数据，然后读出数据
 * 1、如果文件名不写路径，将直接在程序当前文件夹下创建一个新文件
 * 2、文件路径用斜杆和双反斜杆都可以 "D:/a.txt"或者"D:\\a.txt"
 * 3、二进制写入，会出现乱码的情况（windows记事本的编码不是utf-8）
 **/
public class FileStreamDemo {
    public static void main(String[] args) {
        try {
            byte[] writes = {1, 2, 4, 65, 43};
            OutputStream os = new FileOutputStream("a.txt");
            for (byte write : writes) {
                os.write(write);
            }
            os.close();

            InputStream is = new FileInputStream("a.txt");
            int size = is.available();
            for (int i = 0; i < size; i++) {
                System.out.println((char) is.read() + " ");
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
