package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author nigaknight
 * @time 2019/10/22
 * 从控制台获取多字符输入
 * 1、read方法获得的是整型，需要做转换
 * 2、每次调用read都会取走控制台的一个字符，这里用do-while循环比较好
 **/
public class BRReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c;
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
