package com.kgc.ddbuy.ddbuy_manage_web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.ddbuy_common_service.service.TbContentService;
import com.kgc.ddbuy.ddbuy_manage_web.utils.FastDFSUtils;
import com.kgc.ddbuy.pojo.Tb_content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Controller
@ResponseBody
public class ContentController {

    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;

    //使用value注解引用属性文件的键值
    @Value(value = "${fasfdsf_save_address}")
    private String fasfdsf_save_address;

    @Autowired
    private FastDFSUtils fastDfsUitl; //引用文件上传  被SpringIOC加载过 可以引用

    @RequestMapping("/addContent")
    public Map<String, Object> addContent(Tb_content tb_content, @RequestParam(value = "file", required = false) MultipartFile pfile) throws IOException {
        //@RequestParam 指定表单里面的name  这个file是表单里面负责上传文件的file
        //获取上传文件的信息
        System.out.println("文件名" + pfile.getOriginalFilename());
        System.out.println("文件类型 ：" + pfile.getContentType());
        System.out.println(Arrays.toString(pfile.getBytes()));
        //pfile.getBytes() 获取图片的二进制数据

        //1.将上传的文件保存到远程文件服务器上   java操作fastdfs文件服务器
        //添加依赖->添加属性配置文件->编写客户端上传代码
        Map<String, Object> map = new HashMap<>();
        try {
            String filename = pfile.getOriginalFilename(); //得到整个文件名
            String extname = filename.substring(filename.lastIndexOf(".") + 1); //拆解文件名得到后缀名
            //上传文件
            String[] savePath = this.fastDfsUitl.upload_file(pfile.getBytes(), extname);
            System.out.println("保存路径:" + savePath);


            //只是用来控制台输出看看的
            for (String temp : savePath) {
                System.out.println("拆解后的路径为：" + temp);
            }


            if (savePath != null) {
                //调用远程服务实现添加
                tb_content.setPic(this.fasfdsf_save_address + "/" + savePath[0] + "/" + savePath[1]);  //设置图片位置
                if (tbContentService.addTbcontent(tb_content) > 0) {
                    map.put("result", 1);  //返回1表示成功
                } else {
                    //删除文件
                    fastDfsUitl.delete_file(savePath[0], savePath[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            map.put("result", 0);  //返回1表示成功
        }
        return map;
    }


}
