package com.fire.dao;

import com.fire.po.TroubleCheckDate;
import com.fire.po.Troubletable;

import java.util.List;

public interface TroubletableMapper {
    int deleteByPrimaryKey(String troubletableid);

    int insert(Troubletable record);

    int insertSelective(Troubletable record);

    Troubletable selectByPrimaryKey(String troubletableid);

    int updateByPrimaryKeySelective(Troubletable record);

    int updateByPrimaryKey(Troubletable record);

    List<TroubleCheckDate> getTroubletableCheckDate(Integer unitid);
}