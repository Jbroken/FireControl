package com.fire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.FiretableMapper;
import com.fire.dao.ReporttableMapper;
import com.fire.dao.TransfertableMapper;
import com.fire.dao.TroubletableMapper;
import com.fire.po.Reporttable;
import com.fire.po.Transfertable;
import com.fire.po.Troubletable;
import com.fire.utils.dateUtil;

@Service
public class TableService {

	@Autowired
	FiretableMapper firetableMapper;
	@Autowired
	ReporttableMapper reporttableMapper;
	@Autowired
	TroubletableMapper troubletableMapper;
	@Autowired
	TransfertableMapper transfertableMapper;

	// 上传举报投诉消防监督检查记录
	public int uploadReportInfo(Reporttable reporttable) {
		// TODO Auto-generated method stub
		return reporttableMapper.insert(reporttable);
	}

	// 上传火灾隐患报告书
	public int uploadTroubleInfo(Troubletable troubletable) {
		// TODO Auto-generated method stub
		return troubletableMapper.insert(troubletable);
	}

	public int uploadTransferInfo(Transfertable transfertable) {
		// TODO Auto-generated method stub
		// 取当前上传时间为填表时间
		transfertable.setTransferdate(dateUtil.getNowDate());
		return transfertableMapper.insert(transfertable);
	}

}
