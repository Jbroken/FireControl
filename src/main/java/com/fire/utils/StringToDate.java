package com.fire.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将得到的数据转为Date
 * @author Broken
 * @param time
 * @return 返回格式为Date
 */
public class StringToDate {
	
	public static Date singleDate(String time){
		
		//转换时间date
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(time);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}
}
