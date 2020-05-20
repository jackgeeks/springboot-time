package com.wpp.springboottime.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: jackgeeks
 * @ProjectName: springboot-time
 * @Package: com.wpp.springboottime.bean
 * @ClassName: User
 * @Description: @todo
 * @CreateDate: 2020/5/19 12:57
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User {
    private String name;
    private Integer  sex;
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime currenttime;


}
