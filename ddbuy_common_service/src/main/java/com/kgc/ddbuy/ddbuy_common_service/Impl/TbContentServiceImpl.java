package com.kgc.ddbuy.ddbuy_common_service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.ddbuy_common_service.service.TbContentService;
import com.kgc.ddbuy.mapper.Tb_contentMapper;
import com.kgc.ddbuy.pojo.Tb_content;
import com.kgc.ddbuy.pojo.Tb_contentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

//本服务有用到Redis

@Component //SpringIOC
@Service(interfaceClass = TbContentService.class)
public class TbContentServiceImpl implements TbContentService {

    @Autowired(required = false)
    private Tb_contentMapper tb_contentMapper;

    //注入Redis
    @Autowired
    private RedisTemplate redisTemplate;

    //为了解决缓存同步问题而新建的方法 在新增操作后调用重新加入缓存避免新增后缓存里面没有新数据的情况
    public void SetBuffer() {
        ValueOperations<String, Object> option = redisTemplate.opsForValue();
        Tb_contentExample e = new Tb_contentExample();
        Tb_contentExample.Criteria c = e.createCriteria();
        c.andStatusEqualTo("1");
        List<Tb_content> list = tb_contentMapper.selectByExample(e);
        option.set("contentkey", list, 1, TimeUnit.DAYS);
    }


    @Override
    public int addTbcontent(Tb_content tb_content) {
        int i = -1;
        try {
            i = tb_contentMapper.insertSelective(tb_content);
            this.SetBuffer();  //新增后再加入缓存

            //也可以把缓存直接删除了 重加新的缓存即可redisTemplate.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Tb_content> AllTbContent() {
        //实现广告的缓存
        //首先需要判断缓存是否存在 如果有就取 没有就查询数据库并保存至缓存
        Boolean contentkey = this.redisTemplate.hasKey("contentkey");//判断缓存中是否存在值  他的返回值是一个布尔类型
        //从另外一个角度来说也是相当于设置一个键叫contentkey
        //新建一个用来装键值的对象
        ValueOperations<String, Object> option = redisTemplate.opsForValue(); //具有对缓存进行set get方法的对象

        List<Tb_content> list = null;  //新建一个List容器 用来等下装缓存中的数据

        if (contentkey) {
            //存在 获取缓存中的值
            list = (List<Tb_content>) option.get("contentkey");
            System.out.println("正在调取缓存数据....");


        } else {
            System.out.println("读取数据库......");
            //不存在 查询数据库并缓存
            Tb_contentExample e = new Tb_contentExample();
            Tb_contentExample.Criteria c = e.createCriteria();
            c.andStatusEqualTo("1");  //添加条件查所有
            list = tb_contentMapper.selectByExample(e);//将条件添加至查询的持久化操作中
            //存入缓存
            option.set("contentkey", list, 1, TimeUnit.DAYS);  //设置键 设置值  设置时间长度 设置时间类型
            //这里的时间必须要写整体  不能写加减乘除等让他自己去判断的时间

        }

        return list;

    }
}
