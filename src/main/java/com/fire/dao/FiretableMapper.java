package com.fire.dao;

import com.fire.po.CheckCondition;
import com.fire.po.CheckData;
import com.fire.po.Firetable;
import com.fire.po.FiretableAllColumn;
import com.fire.po.FiretableExample;
import com.fire.po.FiretableInformation;
import com.fire.po.PersonalCondition;
import com.fire.po.PoliceCheckInfo;
import com.fire.po.PoliceStInfo;
import com.fire.po.Policestationid;
import com.fire.po.ProblemCount;
import com.fire.po.Tree;
import com.fire.po.TreeModel;
import com.fire.po.UnitChange;
import com.fire.po.UnitInformation;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FiretableMapper {

    int countByExample(FiretableExample example);

    int deleteByExample(FiretableExample example);

    int deleteByPrimaryKey(String firetableid);

    int insert(Firetable record);

    int insertSelective(Firetable record);

    List<Firetable> selectByExample(FiretableExample example);

    Firetable selectByPrimaryKey(String firetableid);

    int updateByExampleSelective(@Param("record") Firetable record, @Param("example") FiretableExample example);

    int updateByExample(@Param("record") Firetable record, @Param("example") FiretableExample example);

    int updateByPrimaryKeySelective(Firetable record);

    int updateByPrimaryKey(Firetable record);
    //得到每个月商铺整改的情况
    @Select("select DATE_FORMAT(changetime,'%Y%m')AS time,COUNT(DATE_FORMAT(changetime,'%Y%m')) AS count from firetable where state= 2 group by changetime" )
	List<UnitChange> countchange();
    //查询每个月问题商铺的个数
    @Select("select DATE_FORMAT(checkdate,'%Y%m')AS time,count ( DATE_FORMAT(checkdate,'%Y%m')) AS count from firetable where state= 1 group by time" )
	List<UnitChange> UnitUnqualified();
    //得到检查者每个月的检查情况
    @Select("select DATE_FORMAT(checkdate,'%Y%m')AS time,count(DATE_FORMAT(checkdate,'%Y%m')) AS count,checker,userid from firetable where checker = #{value} OR userid = #{value} group by time")
	List<PersonalCondition> CountPersonalCondition(String checker);
    //统计检查人员的检查情况
    @Select("select DATE_FORMAT(checkdate,'%Y%m')AS checkdate,count (DATE_FORMAT(checkdate,'%Y%m')) AS count from firetable where checker = #{value} group by checkdate")
	List<CheckCondition> CountRegionCondition(String name);
    //根据派出所ID查询商铺信息
    @Select("select branch.branchid,branch.branchname,policestation.policeid,policestation.policeStation AS policename,unit.unitid,unit.unitname,unit.address,unit.master,firetable.firetableid,firetable.checker,firetable.checkdate from branch,policestation,unit,firetable where branch.branchid = policestation.branchid and policestation.policeid = unit.policeid and unit.unitid = firetable.unitid and policestation.policeid = #{value}")
	List<UnitInformation> SelectInformation(Integer policeid);
    //查询分局
    @Select("select branchid,branchname from branch")
	List<UnitInformation> SelectBranch();
    //根据分局ID来查询派出所信息
    @Select("select policeStation AS policename,policeid from policestation where branchid = #{value}")
	List<UnitInformation> SelectPolice(Integer branchid);
    //得到分局信息
    @Select("select branchid as id,branchname as text from branch")
	List<TreeModel> getTree();
    //得到派出所信息
    @Select("select policeid as id,policeStation as text from policeStation")
    List<Tree> getpolice();
    //根据分局id得到派出所信息
    @Select("select policeid as id,policeStation as text from policestation where branchid = #{value}")
	List<TreeModel> getpolicename(Integer branchid);
    //
    @Select("select unitid as id,unitname as text from unit where policeid = #{value}")
	List<TreeModel> getunit(Integer policeid);
    //根据时间得到消防表册信息
    @Select("select unit.unitname,unit.unitid,unit.master,unit.address,firetable.firetableid,firetable.checker,firetable.checkdate from unit,firetable where unit.unitid = firetable.unitid and firetable.checkdate between #{date1} and #{date2}")
	List<UnitInformation> getFiretableBytime(@Param(value="date1")Date date1, @Param(value="date2")Date date2);
    //根据商铺iD得到表册的检查时间
    @Select("select firetableid,checkdate from firetable where unitid = #{value} ")
	List<CheckData> getCheckdateById(Integer unitid);
    //根据时间获取表册数据
    @Select("select unit.unitid,unit.unitname,unit.master,unit.address,unit.unitproperty,unit.area,unit.floors,unit.height,firetable.unitid,firetable.firetableid,firetable.checker,firetable.otherchecker,firetable.checkdate,firetable.problem,firetable.remarks,firetable.state from unit,firetable  where firetable.unitid = unit.unitid and firetable.firetableid = #{firetableid} and firetable.checkdate=#{date}")
	List<FiretableInformation> getTableByDate(@Param(value="date")Date date,@Param(value="firetableid") String firetableid);
	//获取周期内派出所下商铺被检查的总数
	@Select("select count(firetable.firetableid) as checkCount from unit,firetable where firetable.checkdate between #{singleDate} and #{singleDate2} and unit.policeid = #{policeid} and firetable.unitid = unit.unitid")
	int getCheckCountByDate(@Param(value="singleDate")Date singleDate,@Param(value="singleDate2")Date singleDate2, @Param(value="policeid")String policeid);
	//得到所有的字段和注解
	@Select("select column_name,column_comment from INFORMATION_SCHEMA.Columns where table_name='firetable' and data_type='int'")
	List<FiretableAllColumn> getAllColumn();
	
	@Select("select count(firetableid) as tablesum,sum(${value}=0) as first,sum(${value}=1) as second,sum(${value}=2) as third,sum(${value}=3) as fourth,sum(${value}=4) as fifth from firetable")
	List<ProblemCount> getProblemRate(String column_name);
	//根据场所名称查询表册
	@Select("select unit.unitname,unit.unitid,unit.master,unit.address,firetable.firetableid,firetable.checker,firetable.checkdate from unit,firetable where unit.unitid = firetable.unitid and unit.unitname = #{unitname}")
	List<UnitInformation> getTableByunit(String unitname);
	//获取对应派出所下面的场所的总数
	@Select("select count(unitid=#{policeid}) as unitsum from unit where policeid = #{policeid}")
	List<PoliceCheckInfo> getUnitSum(Policestationid policeid);
	//按天查询选中派出所的检查信息
//	@Select("select policestation.policeStation,sum(firetable.checkdate = #{date}) as tablesum,firetable.checkdate as time from policestation,unit,firetable where policestation.policeid = #{policeid} and firetable.checkdate = #{date} and unit.unitid = firetable.unitid")
	List<PoliceStInfo> getPoliceStInfoByDay(@Param(value="date")Date date,@Param(value="policeid")Policestationid policeid);
	//按周查询选中派出所的检查信息
	@Select("select policestation.policeStation,count(*) as tablesum,DATE_FORMAT(firetable.checkdate,'%v') as time from policestation,unit,firetable where policestation.policeid = unit.policeid = #{policeid.policeid} and unit.unitid = firetable.unitid and firetable.checkdate between DATE_SUB(#{enddate},INTERVAL ${number} week) and #{enddate} group by DATE_FORMAT(firetable.checkdate,'%v')")
	List<PoliceStInfo> getPoliceStInfoByWeek(@Param(value="enddate")Date enddate,@Param(value="number")String number,
			@Param(value="policeid")Policestationid policeid);
	//按月查询选中派出所的检查信息
	@Select("select policestation.policestation,count(*) as tablesum,DATE_FORMAT(firetable.checkdate,'%Y-%m') as time from policestation,unit,firetable where policestation.policeid = unit.policeid = #{policeid.policeid} and unit.unitid = firetable.unitid and firetable.checkdate between DATE_SUB(#{enddate},INTERVAL ${number} month) and #{enddate} group by DATE_FORMAT(firetable.checkdate,'%Y%m')")
	List<PoliceStInfo> getPoliceStInfoByMouth(@Param(value="enddate")Date enddate,@Param(value="number")String number,
			@Param(value="policeid")Policestationid policeid);
    
    
    
}