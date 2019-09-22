package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Tb_user;
import com.kgc.ddbuy.pojo.Tb_userExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_userMapper {
    int countByExample(Tb_userExample example);

    int deleteByExample(Tb_userExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tb_user record);

    int insertSelective(Tb_user record);

    List<Tb_user> selectByExample(Tb_userExample example);

    Tb_user selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tb_user record, @Param("example") Tb_userExample example);

    int updateByExample(@Param("record") Tb_user record, @Param("example") Tb_userExample example);

    int updateByPrimaryKeySelective(Tb_user record);

    int updateByPrimaryKey(Tb_user record);
}