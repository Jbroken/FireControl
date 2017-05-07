package com.fire.service;

import com.fire.dao.TroubletableMapper;
import com.fire.po.TroubleCheckDate;
import com.fire.po.Troubletable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.ReporttableMapper;
import com.fire.dao.TransfertableMapper;
import com.fire.po.Reporttable;
import com.fire.po.Transfertable;
import com.fire.utils.DateUtil;

import java.util.List;

@Service
public class TableService {

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
		transfertable.setTransferdate(DateUtil.getNowDate());
		return transfertableMapper.insert(transfertable);
	}

	public List<TroubleCheckDate> getTroubletableCheckDate(Integer unitid) {
		return troubletableMapper.getTroubletableCheckDate(unitid);
	}
}
