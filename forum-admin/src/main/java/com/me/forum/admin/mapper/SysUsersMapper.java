package com.me.forum.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.me.forum.admin.model.SysUsers;

import java.util.List;


public interface SysUsersMapper extends BaseMapper<SysUsers> {
    List<SysUsers> getListByPhone(long phoneNumber);
}
