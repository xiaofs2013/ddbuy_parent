package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Tb_item_cat;
import com.kgc.ddbuy.pojo.Tb_item_catExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_item_catMapper {
    int countByExample(Tb_item_catExample example);

    int deleteByExample(Tb_item_catExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tb_item_cat record);

    int insertSelective(Tb_item_cat record);

    List<Tb_item_cat> selectByExample(Tb_item_catExample example);

    Tb_item_cat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tb_item_cat record, @Param("example") Tb_item_catExample example);

    int updateByExample(@Param("record") Tb_item_cat record, @Param("example") Tb_item_catExample example);

    int updateByPrimaryKeySelective(Tb_item_cat record);

    int updateByPrimaryKey(Tb_item_cat record);
}