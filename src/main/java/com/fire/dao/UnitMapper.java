package com.fire.dao;

import com.fire.po.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UnitMapper {
	
    int countByExample(UnitExample example);
    
    int deleteByExample(UnitExample example);

    int deleteByPrimaryKey(Integer unitid);

    int insert(Unit record);

    int insertSelective(Map<String, String> map);

    List<Unit> selectByExample(UnitExample example);

    Unit selectByPrimaryKey(Integer unitid);

    int updateByExampleSelective(@Param("record") Unit record, @Param("example") UnitExample example);

    int updateByExample(@Param("record") Unit record, @Param("example") UnitExample example);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
    
    //以下代码由用户自己创建
    
    //根据商铺的性质统计各类商铺的总数
    @Select("select unitproperty,count(unitproperty) as count from unit group by unitproperty")
	List<TestModel> queryCountByType();

    //按周统计检查情况
    @Select("select unit.unitproperty as Category,DATE_FORMAT(firetable.checkdate,'%v')AS week,count(firetable.checkdate)AS count from unit,firetable WHERE unit.unitid = firetable.unitid AND firetable.checkdate between #{date1} and #{date2} group by week,Category")
	List<SingleUnit> getSingleUnitCheckTimesByCategory(@Param("date1") Date date1,@Param("date2") Date date2);

    //按月统计检查情况
  	@Select("select unit.unitproperty as Category,DATE_FORMAT(firetable.checkdate,'%Y%m')AS week,count(firetable.checkdate)AS count from unit,firetable WHERE unit.unitid = firetable.unitid AND firetable.checkdate between #{date1} and #{date2} group by week,Category")
  	List<SingleUnit> getunitbydate(@Param("date1")Date date1,@Param("date2")Date date2);

  	//根据派出所得到商铺信息
    @Select("select unit.unitproperty as type from unit,policestation where  unit.policeid = policestation.policeid and policestation.policeStation = #{policestation} group by unitproperty")
	List<UnitChildren> getType(String policestation);
    
    @Select("select unit.unitid,policestation.policeStation as policestation,unit.unitname,unit.master,unit.address from unit JOIN policestation where unit.policeid = policestation.policeid and unit.unitid = #{unitid}")
	List<UnitMasterImfor> getUnitInformation(int unitid);

    //根据派出所得到商铺信息
    @Select("select unit.unitid as id,unit.rectifyid,unit.reportid,unit.unitname as title,unit.checkstate as state,policestation.policeid,unit.master,unit.address,unit.checkType as checktype,unit.report,task.SetTime,task.Tasktime from policestation,unit,task where unit.policeid = policestation.policeid and policestation.policeStation = #{policestation} and unit.unitid = task.unitid AND unit.unitproperty= #{type}")
	List<UnitType> getUnit(@Param(value="policestation")String policestation, @Param(value="type")String type);

	//获得需整改检查的商铺
	@Select("select unit.unitid as id,unit.rectifyid,unit.reportid,unit.unitname as title,unit.checkstate as state,policestation.policeid,unit.master,unit.address,unit.checkType as checktype,unit.report from policestation,unit where unit.policeid = policestation.policeid and policestation.policeStation = #{policestation} AND unit.unitproperty= #{type} and unit.checkType=1")
	List<UnitType> getRectifyCheckInfo(@Param(value="policestation")String policestation,@Param(value="type")String type);

	//获得举报检查的商铺
	@Select("select unit.unitid as id,unit.rectifyid,unit.reportid,unit.unitname as title,unit.checkstate as state,policestation.policeid,unit.master,unit.address,unit.checkType as checktype,unit.report from policestation,unit where unit.policeid = policestation.policeid and policestation.policeStation = #{policestation} AND unit.unitproperty= #{type} and unit.report=1")
	List<UnitType> getReportCheck(@Param(value="policestation")String policestation,@Param(value="type")String type);

	@Select("select policestation.policestation,policestation.policeid,count(unit.unitid) as unitsum,sum(unit.checkstate=1) as checkunitsum from policestation,unit where policestation.policeid = unit.policeid GROUP BY policestation.policestation")
	List<PoliceCheckInfo> selectPoliceStationCheckCondition();

	//模糊查询场所
	@Select("SELECT unitname FROM unit WHERE unitname LIKE CONCAT(CONCAT('%', #{unitname}), '%')")
	List<Unitname> checkUnitname(String unitname);
	
	int updateCheckstate(Firetable firetable);


	
	
}