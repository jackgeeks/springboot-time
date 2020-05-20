package com.wpp.springboottime.Time;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * @Author: jackgeeks
 * @ProjectName: springboot-time
 * @Package: com.wpp.springboottime.Time
 * @ClassName: test
 * @Description: @todo
 * @CreateDate: 2020/5/19 14:06
 * @Version: 1.0
 */
@Slf4j
public class Zonedome {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS ", Locale.US);

        Calendar cd = Calendar.getInstance();
        // 设置时区为GMT
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String str = sdf.format(cd.getTime());
        log.info("格林尼治标准时间："+str);
        Calendar cd2 = Calendar.getInstance();
        // 设置时区为GMT
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String str2 = sdf.format(cd2.getTime());
        log.info("北京时间："+str2);



        // 输出所有时区
        //Set<String> set = ZoneId.getAvailableZoneIds();
        //set.forEach(System.out::println);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime.atZone(ZoneId.of("Asia/Shanghai"));
        log.info("中国上海时间:"+dateTime);
        log.info("中国上海时间:"+LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
        log.info("美国纽约时间:"+LocalDateTime.now(ZoneId.of("America/New_York")));
        log.info("英国伦敦时间:"+LocalDateTime.now(ZoneId.of("Europe/London")));
        // 带时区的时间或日期
        log.info("中国上海时间(带时区的时间或日期):"+ZonedDateTime.now(ZoneId.of("Asia/Shanghai")));

        log.info("中国上海时间(带时区的时间或日期):"+ZonedDateTime.now());
        // LocalDateTime转为ZonedDateTime（带时区的时间或日期）
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        log.info("中国上海时间(localDateTime):"+localDateTime);
        log.info("中国上海时间(zonedDateTime):"+zonedDateTime);
        // ZonedDateTime（带时区的时间或日期）转 LocalDateTime
        LocalDateTime localDateTime1 = zonedDateTime.toLocalDateTime();
        log.info("中国上海时间(带时区的时间或日期):"+localDateTime1);



    }

}
