package com.me.forum.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.admin.dto.SysUserDto;
import com.me.forum.admin.dto.SysUsersQuery;
import com.me.forum.admin.model.SysUsers;

import java.util.List;

public interface SysUsersService {
    IPage<SysUsers> list(SysUsersQuery sysUsersQuery);

    boolean create(SysUserDto sysUserDto);

    boolean update(int id, SysUserDto sysUserDto);

    boolean delete(int id);

    SysUsers getDetails(int id);

    List<SysUsers> getListByPhone(long phoneNumber);
}
