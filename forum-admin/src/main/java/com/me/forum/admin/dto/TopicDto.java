package com.me.forum.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class TopicDto {
    private Integer id;

    @Schema(description = "话题标题", example = "话题标题xxx")
    @NotBlank(message = "话题标题不能为空")
    private String title;

    @Schema(description = "话题描述", example = "话题描述xxx")
    private String description;

    @Schema(description = "关联用户id")
    @NotNull(message = "关联用户不能为空")
    private Integer mid;
}
