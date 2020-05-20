package com.wpp.springboottime.Time;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @Author: jackgeeks
 * @ProjectName: springboot-time
 * @Package: com.wpp.springboottime.Time
 * @ClassName: LocalTimedome
 * @Description: @todo
 * @CreateDate: 2020/5/19 1:03
 * @Version: 1.0
 */
@Slf4j
public class LocalTimedome {
    public static void main(String[] args) {
    //获取当前时区的日期
        LocalDate localDate = LocalDate.now();
     log.info("localDate: " + localDate);
        //时间
        LocalTime localTime = LocalTime.now();
       log.info("localTime: " + localTime);
        //根据上面两个对象，获取日期时间
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
       log.info("localDateTime: " + localDateTime);
        //使用静态方法生成此对象
        LocalDateTime localDateTime2 = LocalDateTime.now();
       log.info("localDateTime2: " + localDateTime2);
        //格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
       log.info("格式化之后的时间: " + localDateTime2.format(formatter));

        //转化为时间戳(秒)
        long epochSecond = localDateTime2.toEpochSecond(ZoneOffset.of("+8"));
        //转化为毫秒
        long epochMilli = localDateTime2.atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli();
       log.info("时间戳为:(秒) " + epochSecond + "; (毫秒): " + epochMilli);

        //时间戳(毫秒)转化成LocalDateTime
        Instant instant = Instant.ofEpochMilli(epochMilli);
        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(instant, ZoneOffset.systemDefault());
       log.info("时间戳(毫秒)转化成LocalDateTime: " + localDateTime3.format(formatter));
        //时间戳(秒)转化成LocalDateTime
        Instant instant2 = Instant.ofEpochSecond(epochSecond);
        LocalDateTime localDateTime4 = LocalDateTime.ofInstant(instant2, ZoneOffset.systemDefault());
       log.info("时间戳(秒)转化成LocalDateTime: " + localDateTime4.format(formatter));

    }
}
