package com.yan.sa.controllers;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/echo")
public class EchoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @SentinelResource(value = "resource", blockHandler = "exceptionHandler")
    public String hello() {
        logger.info("sessionId = " + request.getRequestedSessionId());
        logger.info("principal = " + request.getUserPrincipal());
        logger.info("isUserInRole = " + request.isUserInRole("USER"));
        logger.info("isUserInRole = " + request.isUserInRole("ROLE_USER"));
        return "Hello";
    }

    public String exceptionHandler(BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at ";
    }
}