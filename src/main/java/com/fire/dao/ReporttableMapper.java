package com.fire.dao;

import com.fire.po.Reporttable;
import com.fire.po.ReporttableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReporttableMapper {
	
    int countByExample(ReporttableExample example);

    int deleteByExample(ReporttableExample example);

    int deleteByPrimaryKey(Integer reportid);

    int insert(Reporttable record);

    int insertSelective(Reporttable record);

    List<Reporttable> selectByExample(ReporttableExample example);

    Reporttable selectByPrimaryKey(Integer reportid);

    int updateByExampleSelective(@Param("record") Reporttable record, @Param("example") ReporttableExample example);

    int updateByExample(@Param("record") Reporttable record, @Param("example") ReporttableExample example);

    int updateByPrimaryKeySelective(Reporttable record);

    int updateByPrimaryKey(Reporttable record);
}