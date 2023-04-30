package com.me.blog.common.dto;

import lombok.Data;

@Data
public class BasePage {
    private long pageNum = 1;
    private long pageSize = 10;
}
