package com.me.forum.admin.dto;

import com.me.forum.common.dto.BasePages;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUsersQuery extends BasePages {
    @Schema(description = "支持id查询，支持数组")
    private List<Long> ids;

    @Schema(description = "用户名查询", example = "xiaoming")
    private String username;

    @Schema(description = "性别", example = "1")
    private Integer gender;

    @Schema(description = "原信息查询，支持模糊查询", example = "哈哈")
    private String metadata;

    @Schema(description = "开始时间，格式为yyyy-MM-dd HH:mm:ss", example = "2025-02-01 10:00:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @Schema(description = "结束时间，格式为yyyy-MM-dd HH:mm:ss", example = "2025-02-01 18:00:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;    // 新增字段
}
