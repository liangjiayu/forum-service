package com.me.forum.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.admin.dto.SysUserDto;
import com.me.forum.admin.dto.SysUsersQuery;
import com.me.forum.admin.model.SysUsers;

public interface SysUsersService {
    IPage<SysUsers> list(SysUsersQuery sysUsersQuery);

    boolean create(SysUserDto sysUserDto);

    boolean update(Integer id, SysUserDto sysUserDto);

    boolean delete(Integer id);

}
