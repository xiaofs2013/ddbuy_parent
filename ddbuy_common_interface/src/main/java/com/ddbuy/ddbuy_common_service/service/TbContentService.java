package com.ddbuy.ddbuy_common_service.service;

import com.kgc.ddbuy.pojo.Tb_content;

import java.util.List;

public interface TbContentService {
    //添加广告 (新增)
    public int addTbcontent(Tb_content tb_content);

    public List<Tb_content> AllTbContent();
}
