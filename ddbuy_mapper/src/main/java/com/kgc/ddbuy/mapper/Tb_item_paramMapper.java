package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Tb_item_param;
import com.kgc.ddbuy.pojo.Tb_item_paramExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_item_paramMapper {
    int countByExample(Tb_item_paramExample example);

    int deleteByExample(Tb_item_paramExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tb_item_param record);

    int insertSelective(Tb_item_param record);

    List<Tb_item_param> selectByExampleWithBLOBs(Tb_item_paramExample example);

    List<Tb_item_param> selectByExample(Tb_item_paramExample example);

    Tb_item_param selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tb_item_param record, @Param("example") Tb_item_paramExample example);

    int updateByExampleWithBLOBs(@Param("record") Tb_item_param record, @Param("example") Tb_item_paramExample example);

    int updateByExample(@Param("record") Tb_item_param record, @Param("example") Tb_item_paramExample example);

    int updateByPrimaryKeySelective(Tb_item_param record);

    int updateByPrimaryKeyWithBLOBs(Tb_item_param record);

    int updateByPrimaryKey(Tb_item_param record);
}