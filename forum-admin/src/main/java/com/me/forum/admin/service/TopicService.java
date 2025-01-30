package com.me.forum.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.admin.dto.TopicDto;
import com.me.forum.admin.model.Topic;
import com.me.forum.admin.dto.TopicPageDto;

public interface TopicService {
    IPage<Topic> list(TopicPageDto topicPageDto);

    boolean create(TopicDto topicDto);

    boolean update(TopicDto topicDto);

    boolean delete(Integer id);
}
