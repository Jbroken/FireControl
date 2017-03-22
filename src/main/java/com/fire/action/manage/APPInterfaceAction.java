package com.fire.action.manage;

import com.fire.po.*;
import com.fire.service.CheckService;
import com.fire.service.TableService;
import com.fire.service.UnitService;
import com.fire.utils.StringToDate;
import com.fire.utils.dateUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 *            为0,1,2 分别是常规检查,整改检查,举报检查
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "getUnit")
	@ResponseBody
	public JSONObject getUnitByType(String policestation, int type){
		if (type == 0) {
			return checkService.findType(policestation);
		} else if (type == 1) {
			return checkService.findRectifyCheck(policestation);
		} else {
			return checkService.findReportCheck(policestation);
		}
	}

	// 得到商铺具体信息
	@RequestMapping(value = "getUnitById")
	@ResponseBody
	public List<UnitMasterImfor> getUnitInformationById(int unitid) {

		return checkService.getUnitInformation(unitid);
	}
	
	// 根据商铺id得到表册的检查日期
	@RequestMapping(value = "getCheckdate")
	@ResponseBody
	public JSONObject getCheckdateById(Integer unitid) {

		JSONObject jsonObject = new JSONObject();

		List<CheckData> time = checkService.getCheckdateById(unitid);

		jsonObject.put("result", time);

		return jsonObject;
	}

	// 根据检查日期得到具体表册
	@RequestMapping(value = "getTableInformation")
	public String getTableInformation(Model model, String checkdate,String firetableid) {
		model.addAttribute("table", checkService.findtableByDate(StringToDate.singleDate(checkdate), firetableid));
		return "APPInterfaceJsp/check";
	}

	// 上传日常检查记录表册
	@RequestMapping(value = "getCheckRecord")
	@ResponseBody
	public JSONObject uploadCheckRecord(Firetable firetable) {
		JSONObject jsonObject = new JSONObject();
		// 判断当前商铺的日常检查表是否为超期和获取该商铺周期信息
		List<Task> task = checkService.selectTaskTime(firetable.getUnitid());

		Date startTime = StringToDate.singleDate(task.get(0).getSettime());	//当前场所所设周期的开始时间
		//周期结束时间
		Date endTime = StringToDate.singleDate(dateUtil.getSpecifiedDayAfter(task.get(0).getSettime(), task.get(0).getTasktime()));
		//表册上传时间
		Date nowTime = StringToDate.singleDate(dateUtil.getNowDate());
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
			checkService.updateSetTime(dateUtil.getNowDate(),
					firetable.getUnitid());

			firetable.setCheckdate(StringToDate.singleDate(dateUtil
					.getNowDate()));
			checkService.UploadCheckRecord(firetable);
			// 上传成功，更新商铺状态为已检查
			firetable.setCheckstate(1);

			unitService.updateCheckstate(firetable);

			jsonObject.put("result", "success");// 上传成功

			return jsonObject;
		}

	}

	// 上传商铺营业前检查信息
	@RequestMapping(value = "uploadBusinessInfor")
	@ResponseBody
	public int uploadBusinessInfor(Checkrecord checkrecord) {

		return checkService.uploadBusinessInfor(checkrecord);
	}

	// 上传举报投诉消防监督检查记录
	@RequestMapping(value = "uploadReportInfo")
	@ResponseBody
	public int uploadReportInfo(Reporttable reporttable) {

		return tableService.uploadReportInfo(reporttable);
	}

	// 上传隐患报告书
	@RequestMapping(value = "uploadTroubleInfo")
	@ResponseBody
	public int uploadTroubleReport(Troubletable troubletable) {

		return tableService.uploadTroubleInfo(troubletable);
	}

	// 上传移交书
	@RequestMapping(value = "uploadTransferInfo")
	@ResponseBody
	public int uploadTransfer(Transfertable transfertable) {
		return tableService.uploadTransferInfo(transfertable);
	}

	//上传表册缓存数据
	@RequestMapping(value = "uploadAllData")
	@ResponseBody
	public void uploadCacheData(CacheData infoList){
		for(TableData tableData : infoList.getTableData()){
			System.out.print(infoList);
			//上传常规检查
			if(tableData.getTableType().equals("日常检查表")){
				uploadCheckRecord(tableData.getFiretable());
			}
			//上传营业前表册的数据
			if(tableData.getTableType().equals("营业前检查表")){
				uploadBusinessInfor(tableData.getCheckrecord());
			}
			//上传举报表表册的数据
			if(tableData.getTableType().equals("举报表")){
				uploadReportInfo(tableData.getReporttable());
			}
			//上传报告书表册的数据
			if(tableData.getTableType().equals("报告书")){
				uploadTroubleReport(tableData.getTroubletable());
			}
			//上传移交书表册的数据
			if(tableData.getTableType().equals("移交书")){
				uploadTransfer(tableData.getTransfertable());
			}
		}
	}

}
