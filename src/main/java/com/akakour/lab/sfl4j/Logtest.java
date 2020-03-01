package com.akakour.lab.sfl4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sfl4j")
public class Logtest {
    private final static Logger logger = LoggerFactory.getLogger(Logtest.class);

    @RequestMapping("/test")
    public String test() {
        for (int i = 0; i < 100; i++) {
            logger.debug("这是一条DEBUG信息");
            logger.info("这是一条INFO信息");
            logger.warn("这是一条WARN信息");
            logger.error("这是一条ERROR信息");
        }
        return "success";
    }

}
