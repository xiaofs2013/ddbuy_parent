package com.kgc.ddbuy.mapper;

import com.kgc.ddbuy.pojo.Admin_users;
import com.kgc.ddbuy.pojo.Admin_usersExample;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface Admin_usersMapper {
    int countByExample(Admin_usersExample example);

    int deleteByExample(Admin_usersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Admin_users record);

    int insertSelective(Admin_users record);

    List<Admin_users> selectByExample(Admin_usersExample example);

    Admin_users selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Admin_users record, @Param("example") Admin_usersExample example);

    int updateByExample(@Param("record") Admin_users record, @Param("example") Admin_usersExample example);

    int updateByPrimaryKeySelective(Admin_users record);

    int updateByPrimaryKey(Admin_users record);
}