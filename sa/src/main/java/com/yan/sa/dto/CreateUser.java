package com.yan.sa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUser {
    private String name;
    private long roleId;
    private  boolean enabled;
}
