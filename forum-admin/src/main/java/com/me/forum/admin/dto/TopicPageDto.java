package com.me.forum.admin.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class TopicPageDto {
    @Parameter(description = "页码，从1开始", example = "1")
    private Integer pageNum = 1;

    @Parameter(description = "分页大小", example = "10")
    private Integer pageSize = 10;
}
