package com.me.forum.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.me.forum.admin.model.Topic;

import java.util.List;

public interface TopicMapper extends BaseMapper<Topic> {
    List<Topic> searchByMid(Integer mid);
}
