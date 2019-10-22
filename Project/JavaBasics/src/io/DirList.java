package io;

import java.io.File;

/**
 * @author nigaknight
 * @time 2019/10/22
 * File类对象是文件夹或者文件的对象
 * 可以用isDirectory方法来判断File对象是否是文件夹
 **/
public class DirList {
    public static void main(String[] args) {
        String path="D:/WorkSpace/Note";
        File file=new File(path);
        if (file.isDirectory()){
            String[] s=file.list();
            if (s!=null){
                for (String value : s) {
                    File subFile = new File(path + "/" + value);
                    if (subFile.isDirectory()) {
                        System.out.println(value + " 是一个文件夹");
                    } else {
                        System.out.println(value + " 不是一个文件夹");
                    }
                }
            }
        } else {
            System.out.println(path+" 不是一个文件夹");
        }
    }
}
