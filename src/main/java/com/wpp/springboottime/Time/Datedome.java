package com.wpp.springboottime.Time;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: jackgeeks
 * @ProjectName: springboot-time
 * @Package: com.wpp.springboottime.Time
 * @ClassName: Date
 * @Description: @todo
 * @CreateDate: 2020/5/18 23:44
 * @Version: 1.0
 */
@Slf4j
public class Datedome {
    public static void main(String[] args) {
        //创建一个代表系统当前日期的Date对象
        Date d1 = new Date();

       log.info("当前时间："+d1);
       log.info("时间毫秒数："+System.currentTimeMillis());

        //y 代表年
        //M 代表月
        //d 代表日
        //H 代表24进制的小时
        //h 代表12进制的小时
        //m 代表分钟
        //s 代表秒
        //S 代表毫秒
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
        String format = sdf.format(d1);
        log.info("格式化后:"+format);

        //使用带参数的构造方法Date(int year, int month, int day) ，
        // 可以构造指定日期的Date类对象，Date类中年份的参数应该是实际需要代表的年份减去1900，
        // 实际需要代表的月份减去1以后的值。
        Date d2 =  new Date(2020-1900, 6-1, 12);//过时了不推荐使用
        log.info("指定时间："+d2);

        //获得年份 （注意年份要加上1900，这样才是日期对象d2所代表的年份）

        int year = d2.getYear() + 1900;//过时了不推荐使用
        log.info("年份："+year);

        //获得月份  （注意月份要加1，这样才是日期对象d2所代表的月份）

        int month = d2.getMonth() + 1;//过时了不推荐使用
        log.info("月份："+month);

        //获得日期

        int date = d2.getDate();//过时了不推荐使用
        log.info("日期："+month);


        //获得小时

        int hour = d2.getHours();//不设置默认为0 。过时了不推荐使用
        log.info("小时："+hour);

        //获得分钟

        int minute = d2.getMinutes();//过时了不推荐使用
        log.info("分钟："+minute);

        //获得秒

        int second = d2.getSeconds();//过时了不推荐使用
        log.info("秒："+second);

        //获得星期 （注意：0代表星期日、1代表星期1、2代表星期2，其他的一次类推了）

        int day = d2.getDay();//过时了不推荐使用
        log.info("星期："+day);
    }
}
