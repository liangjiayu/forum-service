package com.me.forum.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.admin.dto.SysUserDto;
import com.me.forum.admin.dto.SysUsersQuery;
import com.me.forum.admin.mapper.SysUsersMapper;
import com.me.forum.admin.model.SysUsers;
import com.me.forum.admin.service.SysUsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements SysUsersService {

    @Autowired
    SysUsersMapper sysUsersMapper;

    @Override
    public IPage<SysUsers> list(SysUsersQuery sysUsersQuery) {
        Page<SysUsers> page = new Page<>(sysUsersQuery.getPageNum(), sysUsersQuery.getPageSize());
        QueryWrapper<SysUsers> queryWrapper = new QueryWrapper<>();

        return this.sysUsersMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean create(SysUserDto sysUserDto) {
        SysUsers sysUser = new SysUsers();
        BeanUtils.copyProperties(sysUserDto, sysUser);

        return this.sysUsersMapper.insert(sysUser) > 0;
    }

    @Override
    public boolean update(Integer id, SysUserDto sysUserDto) {
        SysUsers sysUser = new SysUsers();
        BeanUtils.copyProperties(sysUserDto, sysUser);
        sysUser.setId(id);

        return this.sysUsersMapper.updateById(sysUser) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return this.sysUsersMapper.deleteById(id) > 0;
    }

}
