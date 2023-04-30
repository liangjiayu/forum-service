package com.me.forum.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.dao.modal.User;
import com.me.forum.service.dto.UserDto;
import com.me.forum.service.dto.UserPageDto;

public interface IUserService {
    IPage<User> list(UserPageDto userPageDto);

    boolean create(UserDto userDto);

    boolean update(UserDto userDto);

    boolean delete(String id);

    User getById(Long id);
}
