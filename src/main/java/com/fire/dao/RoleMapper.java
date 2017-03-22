package com.fire.dao;

import com.fire.po.Role;
import com.fire.po.RoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleid);

    boolean insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    boolean updateByPrimaryKey(Role record);

	int getCountByName(Role role);
    
  //以下代码由用户自己添加
  	@Select("select * from role")
  	List<Role> listAllroles();
  	@Select("select * from role where roleid=#{roleid}")
	Role getRoleById(int roleid);
  	@Select("update role set userlimit=#{userlimit} where roleid=#{roleid}")
	void updateRoleUserlimit(Role role);
}