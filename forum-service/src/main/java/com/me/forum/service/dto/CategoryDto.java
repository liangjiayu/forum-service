package com.me.forum.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDto {
    private long id;

    @NotBlank
    private String name;

    private String description;

    private String icon;

    @NotNull
    private Integer topicId;
}
