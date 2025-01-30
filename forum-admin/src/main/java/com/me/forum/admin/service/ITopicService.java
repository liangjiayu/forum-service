package com.me.forum.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.admin.model.Topic;
import com.me.forum.admin.dto.TopicPageDto;

public interface ITopicService {
    IPage<Topic> list(TopicPageDto topicPageDto);
}
