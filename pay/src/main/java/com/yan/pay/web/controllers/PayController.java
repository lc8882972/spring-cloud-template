package com.yan.pay.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class PayController {
    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    @RequestMapping(value = "pay", method = RequestMethod.GET)
    String get() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

//        attributes.getRequest()
        logger.info("payorder");
        return "PayOrder";
    }
}
