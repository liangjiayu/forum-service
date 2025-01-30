package com.me.forum.admin.dto;

import lombok.Data;

@Data
public class TopicPageDto {
    private long pageNum = 1;
    private long pageSize = 10;
}
