package com.fire.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelImportUtil {
	
	public static List<Map<String, String>> parseExcel(InputStream fis) {  
		
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();  
        try {  
        	//创建新的工作薄
           @SuppressWarnings("resource")
           XSSFWorkbook book = new XSSFWorkbook(fis);  
          
           XSSFSheet sheet = book.getSheetAt(0);
           
           //得到第一行和第最后一行
           
            int firstRow = sheet.getFirstRowNum();  
            int lastRow = sheet.getLastRowNum();  
            //遍历行
            for(int i = firstRow + 1; i<=lastRow; i++) {  
                
            Map<String, String> map = new HashMap<String, String>();  
                  
               XSSFRow row = sheet.getRow(i);
               //得到第一个单元格和最后一个单元格
               int firstCell = row.getFirstCellNum();  
               int lastCell = row.getLastCellNum();  
                  
                  //遍历表头单ֵ，得到健
                for(int j=firstCell; j<lastCell; j++) {  
                  //
                 XSSFCell cell2 = sheet.getRow(firstRow).getCell(j);  
                 
                    String key = cell2.getStringCellValue();  
                      //得到Excel中的数据
                    XSSFCell cell = row.getCell(j);  
                    
                    //判断单元格内容的格式是否为数字 
              if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {  
            	  //如果为数字转换为字符串
                        cell.setCellType(XSSFCell.CELL_TYPE_STRING);  
                    }
              //将数据添加到Val中
                    String val = cell.getStringCellValue();
                 //判断是否只有一行ֵ
                    if(i == firstRow) {  
                        	break;  
                    }else{
                    	map.put(key, val);
                    }  
                }  
                //将数据以键值对的形式添加到List中
                if(i != firstRow) {
                    data.add(map);
                }  
            }  
            
        } catch (IOException e) {  
        	
            e.printStackTrace();  
        }  
        return data;  
    } 
	
}  

