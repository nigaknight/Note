package io;

import java.io.File;

/**
 * @author nigaknight
 * @time 2019/10/22
 * "/tmp/file/innerFile" 这个路径将会把文件夹创建到磁盘根路径下
 * mkdirs相比mkdir，当父文件夹不存在时，将会自动创建
 **/
public class CreateDir {
    public static void main(String[] args) {
        File file=new File("/tmp/file/innerFile");
        boolean mkdir = file.mkdirs();
        System.out.println(mkdir);
    }
}
