package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Tb_order_shipping;
import com.kgc.ddbuy.pojo.Tb_order_shippingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_order_shippingMapper {
    int countByExample(Tb_order_shippingExample example);

    int deleteByExample(Tb_order_shippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Tb_order_shipping record);

    int insertSelective(Tb_order_shipping record);

    List<Tb_order_shipping> selectByExample(Tb_order_shippingExample example);

    Tb_order_shipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Tb_order_shipping record, @Param("example") Tb_order_shippingExample example);

    int updateByExample(@Param("record") Tb_order_shipping record, @Param("example") Tb_order_shippingExample example);

    int updateByPrimaryKeySelective(Tb_order_shipping record);

    int updateByPrimaryKey(Tb_order_shipping record);
}