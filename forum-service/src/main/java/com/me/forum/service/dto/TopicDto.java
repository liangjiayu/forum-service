package com.me.forum.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TopicDto {
    private long id;

    @NotBlank
    private String title;

    private String description;

    private Integer mid;
}
