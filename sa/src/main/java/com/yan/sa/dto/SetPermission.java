package com.yan.sa.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SetPermission {
    private long roleId;
    private List<Long> menuIds;
}
