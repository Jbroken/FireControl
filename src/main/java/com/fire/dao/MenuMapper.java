package com.fire.dao;

import com.fire.po.Menu;
import com.fire.po.MenuExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MenuMapper {

    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);
    
    int updateByPrimaryKey(Menu record);

    /**
     * 以下代码由用户自己添加
     * @return
     */
    //查询主菜单
    @Select("select * from menu where modelid is null")
	List<Menu> listallSubMenu();

    //通过ID查找菜单
    @Select("select * from menu where menuid = #{menuid}")
	Menu getMenuById(Integer menuid);

	//删除
	@Select("delete from menu where menuid = #{menuid} or modelid = #{menuid}")
	void deleteMenuById(Integer menuid);
}