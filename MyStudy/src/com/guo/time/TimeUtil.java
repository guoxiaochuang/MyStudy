package com.guo.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 关于时间
 * @author guoxiaochuang
 *
 */
public class TimeUtil {

	
	public static void getTime() throws ParseException{
		Date date = new Date();
		  //创建不同的日期格式 
        DateFormat df1 = DateFormat.getInstance(); 
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE"); 
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);     //产生一个指定国家指定长度的日期格式，长度不同，显示的日期完整性也不同 
        DateFormat df4 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA); 
        DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EEEEEE", Locale.US); 
        DateFormat df6 = new SimpleDateFormat("yyyy-MM-dd"); 
        DateFormat df7 = new SimpleDateFormat("yyyy年MM月dd日"); 

        //将日期按照不同格式进行输出 
        System.out.println("-------将日期按照不同格式进行输出------"); 
        System.out.println("按照Java默认的日期格式，默认的区域                      : " + df1.format(date)); 
        System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ，系统默认区域      :" + df2.format(date)); 
        System.out.println("按照日期的FULL模式，区域设置为中文                      : " + df3.format(date)); 
        System.out.println("按照指定格式 yyyy年MM月dd日 hh时mm分ss秒 EE ，区域为中文 : " + df4.format(date)); 
        System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ，区域为美国        : " + df5.format(date)); 
        System.out.println("按照指定格式 yyyy-MM-dd ，系统默认区域                  : " + df6.format(date)); 

        //将符合该格式的字符串转换为日期，若格式不相配，则会出错 
        Date date1 = df1.parse("07-11-30 下午2:32"); 
        Date date2 = df2.parse("2007-11-30 02:51:07 星期五"); 
        Date date3 = df3.parse("2007年11月30日 星期五"); 
        Date date4 = df4.parse("2007年11月30日 02时51分18秒 星期五"); 
        Date date5 = df5.parse("2007-11-30 02:51:18 Friday"); 
        Date date6 = df6.parse("2007-11-30"); 

        System.out.println("-------输出将字符串转换为日期的结果------"); 
        System.out.println(date1); 
        System.out.println(date2); 
        System.out.println(date3); 
        System.out.println(date4); 
        System.out.println(date5); 
        System.out.println(date6);
	}
	public static void f2(){
		
//		(1) Calendar转化为Date()  
		Calendar cal=Calendar.getInstance();  
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 0);
		Date date=cal.getTime();  
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EE"); 
		System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ，系统默认区域      :" + df2.format(date)); 
        cal.add(Calendar.DAY_OF_MONTH, 1);
        date=cal.getTime(); 
        System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ，系统默认区域      :" + df2.format(date)); 
//		(2) Date转化为Calendar  
//		Date date=new Date();  
//		Calendar cal=Calendar.getInstance();  
//		cal.setTime(date);  
	}
	public static void f3(){
		Date now = new Date();
//		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//		df.format(now);
//		System.out.println(df.format(now));
		TimeFormatHelper.getFormatDate(now, TimeFormatHelper.TIME_FORMAT_A);
		System.out.println("333--"+TimeFormatHelper.getFormatDate(now, TimeFormatHelper.TIME_FORMAT_B));
		
		String dateStr = "2019-03-05 01:01:01";
		Date date = TimeFormatHelper.convertDate(dateStr);
		System.out.println("2222----"+date);
		
		String dateStr2 = "adf";
//		TimeFormatHelper.checkIsDate(dateStr2);
		System.out.println("4--"+TimeFormatHelper.checkIsDate(dateStr2));

		System.out.println("---------------");
		
		TimeFormatHelper.getFormatTimestamp(dateStr);
		System.out.println("5-"+TimeFormatHelper.getFormatTimestamp(dateStr).toString());
		
	}
	public static void main(String[] args) {
		f3();
	}
}
