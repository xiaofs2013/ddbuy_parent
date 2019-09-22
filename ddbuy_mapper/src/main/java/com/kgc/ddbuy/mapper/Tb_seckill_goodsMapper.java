package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Tb_seckill_goods;
import com.kgc.ddbuy.pojo.Tb_seckill_goodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_seckill_goodsMapper {
    int countByExample(Tb_seckill_goodsExample example);

    int deleteByExample(Tb_seckill_goodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tb_seckill_goods record);

    int insertSelective(Tb_seckill_goods record);

    List<Tb_seckill_goods> selectByExample(Tb_seckill_goodsExample example);

    Tb_seckill_goods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tb_seckill_goods record, @Param("example") Tb_seckill_goodsExample example);

    int updateByExample(@Param("record") Tb_seckill_goods record, @Param("example") Tb_seckill_goodsExample example);

    int updateByPrimaryKeySelective(Tb_seckill_goods record);

    int updateByPrimaryKey(Tb_seckill_goods record);
}