package com.me.forum.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.common.api.ApiException;
import com.me.forum.dao.mapper.MemberMapper;
import com.me.forum.dao.modal.Member;
import com.me.forum.service.dto.MemberLoginDto;
import com.me.forum.service.dto.MemberRegisterDto;
import com.me.forum.service.service.IMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MemberService extends ServiceImpl<MemberMapper, Member> implements IMemberService {


    @Autowired
    MemberMapper memberMapper;

    @Override
    public boolean register(MemberRegisterDto memberRegisterDto) {
        // 检查用户名称是否存在
        QueryWrapper<Member> usernameQuery = new QueryWrapper<>();
        usernameQuery.eq("username", memberRegisterDto.getUsername());
        boolean isExist = this.memberMapper.selectCount(usernameQuery) > 0;
        if (isExist) {
            throw new ApiException("账号名称已存在");
        }

        // 注册用户
        Member member = new Member();
        BeanUtils.copyProperties(memberRegisterDto, member);
        member.setId(null);
        return this.memberMapper.insert(member) > 0;
    }

    @Override
    public Member login(MemberLoginDto memberLoginDto) {
        // 根据账号名称获取用户信息
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", memberLoginDto.getUsername());
        Member member = this.memberMapper.selectOne(queryWrapper);
        if (member == null) {
            throw new ApiException("账号不存在");
        }
        if (!Objects.equals(member.getPassword(), memberLoginDto.getPassword())) {
            throw new ApiException("账号名称或者密码不正确");
        }
        member.setPassword(null);
        return member;
    }
}
