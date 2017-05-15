package com.fire.action.manage;

import com.fire.po.*;
import com.fire.service.CheckService;
import com.fire.service.TableService;
import com.fire.service.UnitService;
import com.fire.utils.StringToDate;
import com.fire.utils.DateUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
public class APPInterfaceAction {
	@Autowired
	CheckService checkService;
	@Autowired
	UnitService unitService;
	@Autowired
	TableService tableService;

	/***
	 * 根据类别和警员所属派出所查询场所
	 * 
	 * @param policestation
	 * @param type
	 *  为0,1,2 分别是常规检查,整改检查,举报检查
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "getUnit")
	@ResponseBody
	public JSONObject getUnitByType(String policestation, int type){
		JSONObject result;
		switch (type){
			case 1:
				result = checkService.findRectifyCheck(policestation);
				break;
			case 2:
				result = checkService.findReportCheck(policestation);
				break;
			default:
				result = checkService.findDailyCheck(policestation);
				break;
		}
		return result;
	}

	/**
	 * 得到商铺具体信息
	 * @param unitid
	 * @return
	 */
	@RequestMapping(value = "getUnitById")
	@ResponseBody
	public List<UnitMasterInfo> getUnitInformationById(int unitid) {

		return checkService.getUnitInformation(unitid);
	}

	/**
	 * 根据商铺id得到表册的检查日期
	 * @param unitid
	 * @return
	 */
	@RequestMapping(value = "getCheckdate")
	@ResponseBody
	public JSONObject getCheckdateById(Integer unitid) {

		JSONObject result = new JSONObject();
		JSONObject tableDate = new JSONObject();

		List<CheckData> dailyCheck = checkService.getCheckdateById(unitid);
		List<TroubleCheckDate> troubleCheckDates = tableService.getTroubletableCheckDate(unitid);

		tableDate.put("dailyCheck",dailyCheck);
		tableDate.put("troubleCheck",troubleCheckDates);

		result.put("result", tableDate);

		return result;
	}

	/**
	 * 根据表册id得到具体表册数据
	 * @param model
	 * @param firetableid
	 * @return
	 */
	@RequestMapping(value = "getTableInformation")
	public String getTableInformation(Model model, String firetableid) {
		model.addAttribute("table", checkService.findtableById(firetableid));
		return "APPInterfaceJsp/check";
	}

	/**
	 *上传日常检查记录表册
	 * @param firetable
	 * @return
	 */
	@RequestMapping(value = "getCheckRecord")
	@ResponseBody
	public JSONObject uploadCheckRecord(Firetable firetable) {
		JSONObject jsonObject = new JSONObject();
		// 判断当前商铺的日常检查表是否为超期和获取该商铺周期信息
		List<Task> task = checkService.selectTaskTime(firetable.getUnitid());

		Date startTime = StringToDate.singleDate(task.get(0).getSettime());	//当前场所所设周期的开始时间
		//周期结束时间
		Date endTime = StringToDate.singleDate(DateUtil.getSpecifiedDayAfter(task.get(0).getSettime(), task.get(0).getTasktime()));
		//表册上传时间
		Date nowTime = StringToDate.singleDate(DateUtil.getNowDate());
		// 未超期
		if (startTime.getTime() <nowTime.getTime() && nowTime.getTime() < endTime.getTime()) {
			//更新场所状态
			firetable.setCheckdate(nowTime);
			firetable.setTasktime(task.get(0).getTasktime());
			firetable.setSettime(task.get(0).getSettime());
			checkService.UploadCheckRecord(firetable);
			// 上传成功，更新场所状态为已检查
			firetable.setCheckstate(1);
			unitService.updateCheckstate(firetable);
			jsonObject.put("result", "success");// 上传成功
			return jsonObject;
		} else {
			// 将当前日期设为新的起始日期
			checkService.updateSetTime(DateUtil.getNowDate(),
					firetable.getUnitid());

			firetable.setCheckdate(StringToDate.singleDate(DateUtil
					.getNowDate()));
			checkService.UploadCheckRecord(firetable);
			// 上传成功，更新商铺状态为已检查
			firetable.setCheckstate(1);

			unitService.updateCheckstate(firetable);

			jsonObject.put("result", "success");// 上传成功

			return jsonObject;
		}

	}

	/**
	 *上传商铺营业前检查信息
	 * @param checkrecord
	 * @return
	 */
	@RequestMapping(value = "uploadBusinessInfor")
	@ResponseBody
	public int uploadBusinessInfo(Checkrecord checkrecord) {

		return checkService.uploadBusinessInfor(checkrecord);
	}

	/**
	 * 上传举报投诉消防监督检查记录
	 * @param reporttable
	 * @return
	 */
	@RequestMapping(value = "uploadReportInfo")
	@ResponseBody
	public int uploadReportInfo(Reporttable reporttable) {

		return tableService.uploadReportInfo(reporttable);
	}

	/**
	 * 上传隐患报告书
	 * @param troubletable
	 * @return
	 */
	@RequestMapping(value = "uploadTroubleInfo")
	@ResponseBody
	public int uploadTroubleReport(Troubletable troubletable) {

		return tableService.uploadTroubleInfo(troubletable);
	}

	/**
	 * 上传移交书
	 * @param transfertable
	 * @return
	 */
	@RequestMapping(value = "uploadTransferInfo")
	@ResponseBody
	public int uploadTransfer(Transfertable transfertable) {
		return tableService.uploadTransferInfo(transfertable);
	}

	/**
	 * 上传表册缓存数据
	 * @param infoList
	 */
	@RequestMapping(value = "uploadAllData")
	@ResponseBody
	public void uploadCacheData(@RequestBody CacheData infoList){
		for (TableData tableData : infoList.getTableData()) {
			tableData.getTableType();
		}
	}

}
