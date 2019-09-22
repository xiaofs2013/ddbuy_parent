package com.kgc.ddbuy.ddbuy_manage_web.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component  //SpringIOC
public class FastDFSUtils {

    //定义属性文件地址 常量
    public final String FastDFS_path = "fastdfs.properties";

    //使用value注解引用属性文件的赋值  引用的配置文件属性  这样不会直接将代码写死  因为改动的频率比较高
    @Value(value = "${fasfdsf_save_address}")
    private String fasfdsf_save_address;


    public String[] upload_file(byte[] bs, String extname) {
        try { //1.加载属性文件
            ClientGlobal.init(this.FastDFS_path);
            // 2、创建一个 TrackerClient 对象。直接 new 一个。
            TrackerClient trackerClient = new TrackerClient();
            // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
            TrackerServer trackerServer = trackerClient.getConnection();
            // 4、创建一个 StorageServer 的引用，值为 null
            StorageServer storageServer = null;
            // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            // 6.上传图片
            //BS代表文件被转换成的二进制数组  extname代表后缀名
            String[] names = storageClient.upload_file(bs, extname, null);
            System.out.println("names为：" + names);

            //只是用来控制台输出看看的
            for (String temp : names) {
                System.out.println("拆解后的names分别为：" + temp);
            }


            return names;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 文件的上传的方法
     */
    public boolean delete_file(String group, String filenme) {
        try { //1.加载属性文件
            ClientGlobal.init(this.FastDFS_path);
            // 2、创建一个 TrackerClient 对象。直接 new 一个。
            TrackerClient trackerClient = new TrackerClient();
            // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
            TrackerServer trackerServer = trackerClient.getConnection();
            // 4、创建一个 StorageServer 的引用，值为 null
            StorageServer storageServer = null;
            // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            // 6.上传图片
            storageClient.delete_file(group, filenme);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return false;
    }

}

