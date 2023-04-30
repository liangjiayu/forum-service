package com.me.forum.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.me.forum.dao.modal.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    User getById(@Param("id") Long id);
}
