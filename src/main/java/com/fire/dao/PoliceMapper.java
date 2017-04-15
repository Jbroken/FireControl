package com.fire.dao;

import com.fire.po.Police;
import com.fire.po.PoliceExample;
import com.fire.po.PoliceInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PoliceMapper {
	
    int countByExample(PoliceExample example);
    
    int deleteByExample(PoliceExample example);

    int deleteByPrimaryKey(Integer id);

    Police insert(Police record);

    int insertSelective(Police record);

    List<Police> selectByExample(PoliceExample example);

    Police selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Police record, @Param("example") PoliceExample example);

    int updateByExample(@Param("record") Police record, @Param("example") PoliceExample example);

    int updateByPrimaryKeySelective(Police record);

    int updateByPrimaryKey(Police record);

	@Select("select user.userid,user.tel,user.password,user.idcard,policestation.policeStation,count(*) as unitCount,sum(unit.checkstate=1) as noCheckCount from user,policestation,unit where tel = #{value} and user.policeid = unit.policeid and user.policeid = policestation.policeid")
    PoliceInfo selectPoliceByName(String tel);
}