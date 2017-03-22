package com.fire.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.AbstractView;

public abstract class ViewExcel extends AbstractView{
	
	protected void buildExcelDocumevt(Map<String,Object> map,HSSFWorkbook book,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=");
		
		OutputStream outputStream = response.getOutputStream();
		book.write(outputStream);
		outputStream.close();
		
	}
}
