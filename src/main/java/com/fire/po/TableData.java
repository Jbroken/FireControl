package com.fire.po;


import java.util.List;

public class  TableData {
	
	private Firetable firetable;	//日常表
	
	private Checkrecord checkrecord;	//营业前检查表
	
	private Reporttable reporttable;	//举报表
	
	private Troubletable troubletable;	//隐患报告书
	
	private Transfertable transfertable;	//移交书
	
	private String tableType;	//表册类型

	public Firetable getFiretable() {
		return firetable;
	}

	public void setFiretable(Firetable firetable) {
		this.firetable = firetable;
	}

	public Checkrecord getCheckrecord() {
		return checkrecord;
	}

	public void setCheckrecord(Checkrecord checkrecord) {
		this.checkrecord = checkrecord;
	}

	public Reporttable getReporttable() {
		return reporttable;
	}

	public void setReporttable(Reporttable reporttable) {
		this.reporttable = reporttable;
	}

	public Troubletable getTroubletable() {
		return troubletable;
	}

	public void setTroubletable(Troubletable troubletable) {
		this.troubletable = troubletable;
	}

	public Transfertable getTransfertable() {
		return transfertable;
	}

	public void setTransfertable(Transfertable transfertable) {
		this.transfertable = transfertable;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	@Override
	public String toString() {
		return "TableData{" +
				"firetable=" + firetable +
				", checkrecord=" + checkrecord +
				", reporttable=" + reporttable +
				", troubletable=" + troubletable +
				", transfertable=" + transfertable +
				", tableType='" + tableType + '\'' +
				'}';
	}
}
