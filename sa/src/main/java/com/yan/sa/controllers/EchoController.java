package com.yan.sa.controllers;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class EchoController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @SentinelResource(value = "resource", blockHandler = "exceptionHandler")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/echo/get")
    public boolean get() {
        return useLocalCache;
    }

    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }
}