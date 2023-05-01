package com.me.forum.service.service;

import com.me.forum.dao.modal.Member;
import com.me.forum.service.dto.MemberLoginDto;
import com.me.forum.service.dto.MemberRegisterDto;

public interface IMemberService {
    boolean register(MemberRegisterDto memberRegisterDto);

    Member login(MemberLoginDto memberLoginDto);
}
