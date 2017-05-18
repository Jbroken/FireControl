package com.fire.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具
 * @param
 * @author Broken
 *
 */
public class DateUtil {
	/**
	 * Calender类获得指定日期加几天
	 * @param specified 为之前的日期
	 * @param d  day 
	 * @author Broken
	 * @return 返回加上周期的日期
	 */	 
	public static String getSpecifiedDayAfter(String specified, int d) {
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specified);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day + d);  
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
        return dayAfter;  
    }
	/**
	 * 一个时间，减去天数
	 * 
	 * @param a date
	 * @param b number
	 * @return 另外一个时间
	 */
	public static String  date(String a, int b) {
		 Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	            date = new SimpleDateFormat("yy-MM-dd").parse(a);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        c.setTime(date);  
	        int day = c.get(Calendar.DATE);  
	        c.set(Calendar.DATE, day - b);  
	        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
	        return dayAfter; 
	}
	/**
	 * 通过SimpleDateFormat获取当前时间
	 * @author Broken
	 * @return 返回当前日期，格式为（"YYYY-mm-dd"）
	 *
	 */
	public static String getNowDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd"); 
		
		String nowDate = sdf.format(new Date());
		
		return nowDate;
	}
	/*****
	 * 
	 * 两个日期做减法
	 * @param a 
	 * @param b
	 * @return 返回天数 day=a-b
	 */
	public static long minusDate(String a, String b){
		long day  =0;
		if (a != null){
			day= (StringToDate.singleDate(a).getTime()-StringToDate.singleDate(b).getTime())/(24*60*60*1000);
		}
		return day;
	}
	/**
	 * 获取当前时间所在年的周数
	 * @param dateTime
	 * @return 当前日期所在的周数
	 */
	public static int getWeekOfYear(String dateTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		try {
			date = format.parse(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);		
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 返回当前日期
	 * 格式为'yyyy-MM-dd'
	 * @return
	 */
	public static String getNowDay(){
		return LocalDate.now().toString();
	}

	/**
	 * 返回date类型的日期
	 * 格式 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static Date stringToDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(date);
	}

	public static void main(String[] args) {
		String a = getNowDay();
		System.out.println(a);
	}
}
