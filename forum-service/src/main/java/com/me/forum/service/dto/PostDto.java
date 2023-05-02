package com.me.forum.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostDto {
    private long id;

    @NotBlank
    private String title;

    private String content;

    private Integer topicId;

    private Integer mid;
}
