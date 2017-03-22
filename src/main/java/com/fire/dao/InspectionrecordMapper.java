package com.fire.dao;

import com.fire.po.Inspectionrecord;
import com.fire.po.InspectionrecordExample;
import com.fire.po.Problem;
import com.fire.po.SingleUnit;
import com.fire.po.TestModel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InspectionrecordMapper {
 
    int countByExample(InspectionrecordExample example);
 
    int deleteByExample(InspectionrecordExample example);
 
    int insert(Inspectionrecord record);
 
    int insertSelective(Inspectionrecord record);
 
    List<Inspectionrecord> selectByExample(InspectionrecordExample example);

    int updateByExampleSelective(@Param("record") Inspectionrecord record, @Param("example") InspectionrecordExample example);

    int updateByExample(@Param("record") Inspectionrecord record, @Param("example") InspectionrecordExample example);

	
    //以下代码有用户自己添加
    //根据商铺性质得到各类商铺的数量
    @Select("select institutionCategory as institutionCategory,count(institutionCategory) as count from institution group by institutionCategory")
    List<TestModel> queryCountByType();
    //查询各类问题的商铺的总数
	@Select("select")
    List<Problem> countProblem();
    //根据商铺名得到商铺信息
    @Select("select * from inspectionrecord where nstitution = #{value} ")
	List<Inspectionrecord> getInformationByname(String name);
    


}