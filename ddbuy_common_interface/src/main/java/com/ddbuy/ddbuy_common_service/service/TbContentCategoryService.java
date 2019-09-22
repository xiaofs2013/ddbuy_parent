package com.ddbuy.ddbuy_common_service.service;

import com.github.pagehelper.PageInfo;
import com.kgc.ddbuy.pojo.Tb_content_category;
import com.kgc.ddbuy.utils.Page;

import java.util.List;

public interface TbContentCategoryService {

    //添加

    //删除

    //修改

    //查单条

    //查询
    PageInfo<Tb_content_category> GetCategoryByPage(Page page);

    //查询所有广告分类
    List<Tb_content_category> GetAllContentCategory();

}
