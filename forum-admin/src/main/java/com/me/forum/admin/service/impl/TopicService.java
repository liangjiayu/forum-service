package com.me.forum.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.admin.mapper.TopicMapper;
import com.me.forum.admin.model.Topic;
import com.me.forum.admin.dto.TopicPageDto;
import com.me.forum.admin.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public IPage<Topic> list(TopicPageDto topicPageDto) {
        Page<Topic> page = new Page<>(topicPageDto.getPageNum(), topicPageDto.getPageSize());
        QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
        IPage<Topic> records = this.topicMapper.selectPage(page, queryWrapper);

        return records;
    }
}
