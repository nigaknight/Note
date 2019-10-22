package io;

import java.io.File;

/**
 * @author nigaknight
 * @time 2019/10/22
 * 直接delete就能删除文件或文件夹，但这有个前提，就是该文件夹是空的，所以要删除整个文件夹需要递归的删除子文件夹和子文件
 **/
public class DeleteFileDemo {
    public static void main(String[] args) {
        File file=new File("/tmp/java");
        file.mkdirs();
        deleteFile(file);
    }
    private static void deleteFile(File file){
        File[] subFiles=file.listFiles();
        if (subFiles!=null){
            for (File subFile:subFiles){
                if (subFile.isDirectory()){
                    deleteFile(subFile);
                } else {
                    boolean delete = subFile.delete();
                    System.out.println(delete);
                }
            }
        }
        System.out.println(file.delete());
    }
}
