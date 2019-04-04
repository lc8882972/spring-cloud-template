package com.yan.sa.controllers;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yan.sa.annotation.LogEnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@RestController
@RequestMapping("/echo")
public class EchoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HttpServletRequest request;

    @LogEnable()
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @SentinelResource(value = "resource", blockHandler = "exceptionHandler")
    public String hello() {
        Principal principal = request.getUserPrincipal();

        logger.info(request.getUserPrincipal().getName());
        return "Hello";
    }

    public String exceptionHandler(BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at ";
    }
}