package com.me.forum.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.dao.modal.Topic;
import com.me.forum.service.dto.TopicDto;
import com.me.forum.service.dto.TopicPageDto;

public interface ITopicService {
    IPage<Topic> list(TopicPageDto topicPageDto);

    boolean create(TopicDto topicDto);

    boolean update(TopicDto topicDto);

    boolean delete(String id);
}
