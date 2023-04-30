package com.me.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.blog.dao.mapper.UserMapper;
import com.me.blog.dao.modal.User;
import com.me.blog.service.dto.UserDto;
import com.me.blog.service.dto.UserPageDto;
import com.me.blog.service.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public IPage<User> list(UserPageDto userPageDto) {
        Page<User> page = new Page<>(userPageDto.getPageNum(), userPageDto.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        return this.userMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean create(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setId(null);

        return this.userMapper.insert(user) > 0;
    }

    @Override
    public boolean update(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        return this.userMapper.updateById(user) > 0;
    }

    @Override
    public boolean delete(String id) {
        return this.userMapper.deleteById(id) > 0;
    }

    @Override
    public User getById(Long id) {
        return this.userMapper.getById(id);
    }
}
