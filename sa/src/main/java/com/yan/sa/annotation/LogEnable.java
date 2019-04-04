package com.yan.sa.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LogEnable {
    boolean logEnanle() default  true;
}
