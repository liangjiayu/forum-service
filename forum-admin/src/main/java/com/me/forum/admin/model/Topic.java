package com.me.forum.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("topic")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "话题id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "话题标题")
    private String title;

    @Schema(description = "话题描述")
    private String description;

    @Schema(description = "关联的用户id")
    private Integer mid;
}
