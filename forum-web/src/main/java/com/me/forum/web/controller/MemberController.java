package com.me.forum.web.controller;

import com.me.forum.common.api.CommonResult;
import com.me.forum.service.dto.MemberLoginDto;
import com.me.forum.service.dto.MemberRegisterDto;
import com.me.forum.service.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    IMemberService memberService;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody @Valid MemberRegisterDto memberRegisterDto) {
        boolean result = this.memberService.register(memberRegisterDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody @Valid MemberLoginDto memberLoginDto) {
        return CommonResult.success(this.memberService.login(memberLoginDto));
    }
}
