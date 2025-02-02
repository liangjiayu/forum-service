package com.me.forum.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.admin.dto.SysUserCreateDto;
import com.me.forum.admin.dto.SysUserUpdateDto;
import com.me.forum.admin.dto.SysUsersQuery;
import com.me.forum.admin.model.SysUsers;

import java.util.List;

public interface SysUsersService {
    IPage<SysUsers> list(SysUsersQuery sysUsersQuery);

    int create(SysUserCreateDto sysUserCreateDto);

    boolean update(int id, SysUserUpdateDto sysUserUpdateDto);

    boolean delete(int id);

    SysUsers getDetails(int id);

    List<SysUsers> getListByPhone(long phoneNumber);
}
