package com.me.forum.admin.dto;

import lombok.Data;


@Data
public class TopicDto {
    private long id;

    private String title;

    private String description;

    private Integer mid;
}
