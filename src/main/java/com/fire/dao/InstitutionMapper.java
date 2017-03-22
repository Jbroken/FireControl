package com.fire.dao;

import com.fire.po.Institution;
import com.fire.po.InstitutionExample;
import com.fire.po.PoliceStation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InstitutionMapper {

    int countByExample(InstitutionExample example);

    int deleteByExample(InstitutionExample example);

    int insert(Institution record);

    int insertSelective(Institution record);

    List<Institution> selectByExample(InstitutionExample example);

    int updateByExampleSelective(@Param("record") Institution record, @Param("example") InstitutionExample example);

    int updateByExample(@Param("record") Institution record, @Param("example") InstitutionExample example);
    
    
    
    //
    @Select("select * from institution where InstitutionName=#{value}")
	List<Institution> CheckByStation(String institutionName);
    @Select("select * from policestation")
	List<PoliceStation> checkpolice();
}