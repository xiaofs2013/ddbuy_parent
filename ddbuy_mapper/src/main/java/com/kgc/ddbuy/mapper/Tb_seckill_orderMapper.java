package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Tb_seckill_order;
import com.kgc.ddbuy.pojo.Tb_seckill_orderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_seckill_orderMapper {
    int countByExample(Tb_seckill_orderExample example);

    int deleteByExample(Tb_seckill_orderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tb_seckill_order record);

    int insertSelective(Tb_seckill_order record);

    List<Tb_seckill_order> selectByExample(Tb_seckill_orderExample example);

    Tb_seckill_order selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tb_seckill_order record, @Param("example") Tb_seckill_orderExample example);

    int updateByExample(@Param("record") Tb_seckill_order record, @Param("example") Tb_seckill_orderExample example);

    int updateByPrimaryKeySelective(Tb_seckill_order record);

    int updateByPrimaryKey(Tb_seckill_order record);
}