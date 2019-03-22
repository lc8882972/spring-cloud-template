package com.yan.book.controllers;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @RequestMapping(value = "/echo/{s}", method = RequestMethod.GET)
    @SentinelResource(value = "echo", blockHandler = "exceptionHandler", fallback = "echoFallback")
    public String echo(@PathVariable long s) {
        return "echo," + s;
    }

    public String echoFallback(long s) {
        return String.format("Halooooo %d", s);
    }

    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }
}