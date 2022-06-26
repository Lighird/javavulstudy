package com.example.springdemo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log4j")
public class Log4jController {
    private static final Logger logger = LogManager.getLogger();
    @GetMapping("evil")
    public String getEvil(@RequestParam(value="payload",defaultValue = "world")String payload){
        System.out.println(payload);
        logger.error(payload);
        return "Get payload "+ payload;
    }

    @PostMapping("evil")
    public String postEvil(@RequestBody String payload){
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        logger.error(payload);
        return "Post payload "+payload;
    }

}
