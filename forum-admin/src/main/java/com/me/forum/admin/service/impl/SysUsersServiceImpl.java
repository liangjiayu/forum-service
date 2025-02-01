package com.me.forum.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.admin.dto.SysUserDto;
import com.me.forum.admin.dto.SysUsersQuery;
import com.me.forum.admin.mapper.SysUsersMapper;
import com.me.forum.admin.model.SysUsers;
import com.me.forum.admin.service.SysUsersService;
import com.me.forum.common.exception.ApiException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements SysUsersService {

    @Autowired
    SysUsersMapper sysUsersMapper;

    @Override
    public IPage<SysUsers> list(SysUsersQuery sysUsersQuery) {
        if (sysUsersQuery.getStartTime() != null && sysUsersQuery.getEndTime() != null
                && sysUsersQuery.getStartTime().isAfter(sysUsersQuery.getEndTime())) {
            throw new ApiException("开始时间不能晚于结束时间");
        }

        Page<SysUsers> page = new Page<>(sysUsersQuery.getPageNum(), sysUsersQuery.getPageSize());
        LambdaQueryWrapper<SysUsers> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        // 查询多个ID
        if (sysUsersQuery.getIds() != null && !sysUsersQuery.getIds().isEmpty()) {
            lambdaQueryWrapper.in(SysUsers::getId, sysUsersQuery.getIds());
        }
        // 查询用户名
        if (StringUtils.isNotBlank(sysUsersQuery.getUsername())) {
            lambdaQueryWrapper.eq(SysUsers::getUsername, sysUsersQuery.getUsername());
        }
        // 查询性别
        if (sysUsersQuery.getGender() != null) {
            lambdaQueryWrapper.eq(SysUsers::getGender, sysUsersQuery.getGender());
        }
        // 模糊查询 元信息
        if (StringUtils.isNotBlank(sysUsersQuery.getMetadata())) {
            lambdaQueryWrapper.like(SysUsers::getMetadata, sysUsersQuery.getMetadata());
        }
        // 时间范围查询
        if (sysUsersQuery.getStartTime() != null) {
            lambdaQueryWrapper.ge(SysUsers::getCreatedAt, sysUsersQuery.getStartTime());
        }
        if (sysUsersQuery.getEndTime() != null) {
            lambdaQueryWrapper.le(SysUsers::getCreatedAt, sysUsersQuery.getEndTime());
        }
        return this.sysUsersMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public boolean create(SysUserDto sysUserDto) {
        SysUsers sysUser = new SysUsers();
        BeanUtils.copyProperties(sysUserDto, sysUser);

        /* 验证用户名是否唯一 */
        Long usernameCount = lambdaQuery().eq(SysUsers::getUsername, sysUser.getUsername()).count();
        if (usernameCount > 0) {
            throw new ApiException("用户名已存在!");
        }

        return this.sysUsersMapper.insert(sysUser) > 0;
    }

    @Override
    public boolean update(Integer id, SysUserDto sysUserDto) {
        /* 清空不可编辑字段 */
        sysUserDto.setUsername(null);
        sysUserDto.setPassword(null);

        SysUsers sysUser = new SysUsers();
        BeanUtils.copyProperties(sysUserDto, sysUser);
        sysUser.setId(id);

        return this.sysUsersMapper.updateById(sysUser) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return this.sysUsersMapper.deleteById(id) > 0;
    }

    @Override
    public SysUsers getDetails(int id) {
        return this.sysUsersMapper.selectById(id);
    }

    @Override
    public List<SysUsers> getListByPhone(long phoneNumber) {
        return this.sysUsersMapper.getListByPhone(phoneNumber);
    }
}
