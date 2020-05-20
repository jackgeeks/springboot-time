package com.wpp.springboottime.Time;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @Author: jackgeeks
 * @ProjectName: springboot-time
 * @Package: com.wpp.springboottime.Time
 * @ClassName: Calendardome
 * @Description: @todo
 * @CreateDate: 2020/5/19 0:21
 * @Version: 1.0
 */
@Slf4j
public class Calendardome {
    public static void main(String[] args) {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss HHH" );

        // 使用当前时间创建
        Calendar calendar1 = Calendar.getInstance();
        log.info("当前时间："+calendar1);
        log.info("格式化后:"+sdf.format(calendar1.getTime()));
        // 指定时间创建，参数依次为：年，月，日，时，分，秒，月份需要减一
        Calendar calendar2 = new GregorianCalendar(2016, 8, 1, 15, 41, 22);
        log.info("指定时间："+calendar2);

        log.info("格式化后:"+sdf.format(calendar2.getTime()));
         //获得年
        int year = calendar2.get(Calendar.YEAR);
        log.info("年："+year);
        // 取月份要加1
        int month = calendar2.get(Calendar.MONTH) + 1;
        log.info("月份："+month);
        //获得天
        int day = calendar2.get(Calendar.DAY_OF_MONTH);
        log.info("天："+day);
        //获得时
        int hover = calendar2.get(Calendar.HOUR_OF_DAY);
        log.info("时："+hover);
        //获得分钟
        int minute = calendar2.get(Calendar.MINUTE);
        log.info("分钟："+minute);
        //获得秒
        int seconds = calendar2.get(Calendar.SECOND);
        log.info("秒："+seconds);
       // 1-7分别代表 -- 星期日,星期一,星期二,星期三,星期四,星期五,星期六
        //获得星期
        int week = calendar2.get(Calendar.DAY_OF_WEEK);
        log.info("星期："+week);

        String timeDeffer = getTimeDeffer(sdf.format(calendar1.getTime()), sdf.format(calendar2.getTime()));
         log.info(timeDeffer);

    }
    /**
     2      * 获取时间差
     3      * @param time1 time2 需要计算的时间
     4      * @return
     5      */
      public static String getTimeDeffer(String time1,String time2)
    {
               String result = "";
                 if(StringUtils.isNotBlank(time1)&& StringUtils.isNotBlank(time2)){
                      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                      try {
                               long dt1 = sdf.parse( time1 ).getTime();
                               long dt2 = sdf.parse( time2 ).getTime();
                                long dc = Math.abs(dt2-dt1);
                                long seconds = dc/1000;
                                long date = seconds/(24*60*60);     //相差的天数
                          long hour = (seconds-date*24*60*60)/(60*60);//相差的小时数
                                long minut = (seconds-date*24*60*60-hour*60*60)/(60);//相差的分钟数
                          long second = (seconds-date*24*60*60-hour*60*60-minut*60);//相差的秒数
                          return (date==0?"":(date+"天"))+(hour==0?"":(hour+"小时"))+(minut==0?"":(minut+"分"))+(second==0?"":(second+"秒"));
                      } catch ( ParseException e) {
                          e.printStackTrace();
                             }
                     }
                 return result;
             }
}
