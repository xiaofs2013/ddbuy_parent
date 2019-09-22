package com.FastDFS;

import org.csource.fastdfs.*;

import java.io.FileOutputStream;

public class Test1 {
    //使用JAVA程序上传图片到FastDFS
    public static void main(String[] args) throws Exception {
        //使用api来操作FastDFS
        //加载属性文件
        ClientGlobal.init("fastdfs.properties");
        //2.创建tracker服务器对象
        TrackerClient client = new TrackerClient();
        TrackerServer trackerServer = client.getConnection();
        //3.创建storage对象
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //4.下载图片  代码执行后会将图片转换成二进制数据 全部存入这个字节数组
        byte[] bytes = storageClient.download_file("group1", "M00/00/00/wKgBHl13_46EBETtAAAAAOk00Gs812.jpg");
        //将返回的二进制数据写入到本地去
        //流Stream
        //流的分类：输入流inputstream  读文件、输出流outputstream    写文件write
        //保存到D盘下面 文件名为a.jpg
        FileOutputStream outputStream = new FileOutputStream("d:\\a.jpg");
        outputStream.write(bytes);   //写文件
        outputStream.flush();  //清除缓存
        outputStream.close();//关闭流
        System.out.println("下载成功");

        //5.关闭
        trackerServer.close();

    }
}
