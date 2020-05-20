package com.wpp.springboottime.controller;

import com.wpp.springboottime.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * @Author: jackgeeks
 * @ProjectName: springboot-time
 * @Package: com.wpp.springboottime.controller
 * @ClassName: TimeController
 * @Description: @todo
 * @CreateDate: 2020/5/19 12:54
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class TimeController {


   @PostMapping()
   public ResponseEntity<User> save(@RequestBody User user){
     log.info("用户"+user);
       return ResponseEntity.ok(user);
   }
}
