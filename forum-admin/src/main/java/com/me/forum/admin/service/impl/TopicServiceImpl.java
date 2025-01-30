package com.me.forum.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.admin.dto.TopicDto;
import com.me.forum.admin.mapper.TopicMapper;
import com.me.forum.admin.model.Topic;
import com.me.forum.admin.dto.TopicPageDto;
import com.me.forum.admin.service.TopicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

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
    public boolean delete(Integer id) {
        return this.topicMapper.deleteById(id) > 0;
    }

    @Override
    public List<Topic> searchByMid(Integer mid) {
        return this.topicMapper.searchByMid(mid);
    }

}
