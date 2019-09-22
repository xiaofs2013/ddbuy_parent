package com.kgc.ddbuy.ddbuy_common_service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.ddbuy_common_service.service.TbContentCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.ddbuy.mapper.Tb_content_categoryMapper;
import com.kgc.ddbuy.pojo.Tb_content_category;
import com.kgc.ddbuy.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //装入容器  创建本地对象 SpringIOC
@Service(interfaceClass = TbContentCategoryService.class)  //暴露服务 支持远程访问
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired(required = false)
    private Tb_content_categoryMapper tb_content_categoryMapper;

    @Override
    public PageInfo<Tb_content_category> GetCategoryByPage(Page page) {

        //实现分页
        PageHelper.startPage(page.getPage(), page.getRows());

        //查所有
        List<Tb_content_category> list = tb_content_categoryMapper.selectByExample(null);

        //将结果集封装到Page里面进行分页
        PageInfo<Tb_content_category> pageInfo = new PageInfo<Tb_content_category>(list);


        return pageInfo;
    }

    @Override
    public List<Tb_content_category> GetAllContentCategory() {

        List<Tb_content_category> list = tb_content_categoryMapper.selectByExample(null);

        return list;
    }
}
