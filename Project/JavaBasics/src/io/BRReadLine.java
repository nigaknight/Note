package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author nigaknight
 * @time 2019/10/22
 * BufferedReader没有hasNext方法，适合使用do-while型循环来连续读取数据
 **/
public class BRReadLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }
}
