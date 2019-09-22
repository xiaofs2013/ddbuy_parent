package com.FastDFS;

import org.csource.fastdfs.*;

public class Test {
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
        //4.上传图片  地址+后缀+null
        String[] infos = storageClient.upload_appender_file("d:\\718f82e367fed8c0ed33ce403e19ac4413b768aa.jpg", "jpg", null);
        System.out.println("上传成功！！！！，返回信息如下：");
        for (String s : infos) {
            System.out.println(s);
        }

        //5.删除图片   组名 + 文件名
        //int i =storageClient.delete_file("group1","718f82e367fed8c0ed33ce403e19ac4413b768aa.jpg")

        //5.关闭
        trackerServer.close();

    }
}
