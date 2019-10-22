package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author nigaknight
 * @time 2019/10/22
 **/
public class UTF8FileStreamDemo {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("b.txt");
            OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            osw.write("使用中文写入\n");
            osw.write("English");
            osw.close();
            os.close();
            InputStream is = new FileInputStream("b.txt");
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            while (isr.ready()) {
                sb.append((char) isr.read());
            }
            System.out.println(sb.toString());
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
