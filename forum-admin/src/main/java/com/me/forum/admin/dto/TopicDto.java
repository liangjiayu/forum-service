package com.me.forum.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class TopicDto {
    private Integer id;

    @Schema(description = "话题标题", example = "话题标题xxx")
    private String title;

    @Schema(description = "话题描述", example = "话题描述xxx")
    private String description;

    @Schema(description = "关联用户id")
    private Integer mid;
}
