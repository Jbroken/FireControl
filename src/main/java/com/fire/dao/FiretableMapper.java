package com.fire.dao;

import com.fire.po.CheckData;
import com.fire.po.Firetable;
import com.fire.po.FiretableExample;
import com.fire.po.FiretableInformation;
import com.fire.po.PersonalCondition;
import com.fire.po.PoliceCheckInfo;
import com.fire.po.PoliceStInfo;
import com.fire.po.Policestationid;
import com.fire.po.Tree;
import com.fire.po.TreeModel;
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



    //得到检查者每个月的检查情况
	List<PersonalCondition> CountPersonalByChecker(String checker);

	List<PersonalCondition> CountPersonalByUserid(int userid);

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

    //派出所下场所信息
    @Select("select unitid as id,unitname as text from unit where policeid = #{value}")
	List<TreeModel> getunit(Integer policeid);

    //根据时间得到消防表册信息
    @Select("select unit.unitname,unit.unitid,unit.master,unit.address,firetable.firetableid,firetable.checker,firetable.checkdate from unit,firetable where unit.unitid = firetable.unitid and firetable.checkdate between #{date1} and #{date2}")
	List<UnitInformation> getFiretableBytime(@Param(value="date1")Date date1, @Param(value="date2")Date date2);

    //根据商铺iD得到表册的检查时间
    @Select("select firetableid,checkdate from firetable where unitid = #{value} ")
	List<CheckData> getCheckdateById(Integer unitid);

    //根据表册id获取表册数据
	FiretableInformation getTableById(String firetableid);

	//根据场所名称查询表册
	@Select("select unit.unitname,unit.unitid,unit.master,unit.address,firetable.firetableid,firetable.checker,firetable.checkdate from unit,firetable where unit.unitid = firetable.unitid and unit.unitname = #{unitname}")
	List<UnitInformation> getTableByunit(String unitname);

	//获取对应派出所下面的场所的总数
	@Select("select count(unitid=#{policeid}) as unitsum from unit where policeid = #{policeid}")
	List<PoliceCheckInfo> getUnitSum(Policestationid policeid);

	//按天查询选中派出所的检查信息
	PoliceStInfo getPoliceStInfoByDay(@Param(value="date")Date date,@Param(value="Policestationid")Policestationid policeid);

	//按周查询选中派出所的检查信息
	@Select("select policestation.policeStation,count(*) as tablesum,DATE_FORMAT(firetable.checkdate,'%v') as time from policestation,unit,firetable where policestation.policeid = #{policeid.policeid} and firetable.checkdate between DATE_SUB(#{enddate},INTERVAL ${number} week) and #{enddate} and unit.unitid = firetable.unitid group by DATE_FORMAT(firetable.checkdate,'%v')")
	List<PoliceStInfo> getPoliceStInfoByWeek(@Param(value="enddate")Date enddate,@Param(value="number")String number,
			@Param(value="policeid")Policestationid policeid);

	//按月查询选中派出所的检查信息
	@Select("select policestation.policestation,count(*) as tablesum,DATE_FORMAT(firetable.checkdate,'%Y-%m') as time from policestation,unit,firetable where policestation.policeid = #{policeid.policeid} and firetable.checkdate between DATE_SUB(#{enddate},INTERVAL ${number} month) and #{enddate} and unit.unitid = firetable.unitid group by DATE_FORMAT(firetable.checkdate,'%Y%m')")
	List<PoliceStInfo> getPoliceStInfoByMouth(@Param(value="enddate")Date enddate,@Param(value="number")String number,
			@Param(value="policeid")Policestationid policeid);

}