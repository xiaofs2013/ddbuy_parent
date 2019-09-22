package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Tb_item;
import com.kgc.ddbuy.pojo.Tb_itemExample;
import com.kgc.ddbuy.utils.ProductSolr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_itemMapper {
    int countByExample(Tb_itemExample example);

    int deleteByExample(Tb_itemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tb_item record);

    int insertSelective(Tb_item record);

    List<Tb_item> selectByExample(Tb_itemExample example);

    Tb_item selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tb_item record, @Param("example") Tb_itemExample example);

    int updateByExample(@Param("record") Tb_item record, @Param("example") Tb_itemExample example);

    int updateByPrimaryKeySelective(Tb_item record);

    int updateByPrimaryKey(Tb_item record);

    //查询所有的商品信息导入Solr索引库  在Mapper.XML中也进行了
    List<ProductSolr> GetAllProductSolr();

}