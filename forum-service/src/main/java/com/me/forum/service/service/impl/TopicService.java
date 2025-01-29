package com.me.forum.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.dao.mapper.TopicMapper;
import com.me.forum.dao.modal.Topic;
import com.me.forum.service.dto.TopicDto;
import com.me.forum.service.dto.TopicPageDto;
import com.me.forum.service.service.ITopicService;
import org.springframework.beans.BeanUtils;
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

        return this.topicMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean create(TopicDto topicDto) {
        Topic topic = new Topic();
        BeanUtils.copyProperties(topicDto, topic);
        topic.setId(null);

        return this.topicMapper.insert(topic) > 0;
    }

    @Override
    public boolean update(TopicDto topicDto) {
        Topic topic = new Topic();
        BeanUtils.copyProperties(topicDto, topic);

        return this.topicMapper.updateById(topic) > 0;
    }

    @Override
    public boolean delete(String id) {
        return this.topicMapper.deleteById(id) > 0;
    }

    @Override
    public boolean isExist(Integer id) {
        return this.topicMapper.selectById(id) != null;
    }
}
