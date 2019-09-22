package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Tb_content_category;
import com.kgc.ddbuy.pojo.Tb_content_categoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_content_categoryMapper {
    int countByExample(Tb_content_categoryExample example);

    int deleteByExample(Tb_content_categoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tb_content_category record);

    int insertSelective(Tb_content_category record);

    List<Tb_content_category> selectByExample(Tb_content_categoryExample example);

    Tb_content_category selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tb_content_category record, @Param("example") Tb_content_categoryExample example);

    int updateByExample(@Param("record") Tb_content_category record, @Param("example") Tb_content_categoryExample example);

    int updateByPrimaryKeySelective(Tb_content_category record);

    int updateByPrimaryKey(Tb_content_category record);
}