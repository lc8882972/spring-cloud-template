package com.yan.book;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @RestController
    public class EchoController {
        @NacosValue("cache")
        private boolean cache;

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
}
