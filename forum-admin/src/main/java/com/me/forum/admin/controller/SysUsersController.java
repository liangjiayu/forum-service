package com.me.forum.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.admin.dto.SysUserDto;
import com.me.forum.admin.dto.SysUsersQuery;
import com.me.forum.admin.model.SysUsers;
import com.me.forum.admin.service.SysUsersService;
import com.me.forum.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/sys_users")
@Tag(name = "用户管理", description = "用户管理API")
public class SysUsersController {
    @Autowired
    SysUsersService sysUsersService;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "获取用户列表")
    public CommonResult<IPage<SysUsers>> list(@Validated @ParameterObject SysUsersQuery sysUsersQuery) {
        IPage<SysUsers> records = this.sysUsersService.list(sysUsersQuery);
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建用户")
    public CommonResult<Boolean> create(@Validated @RequestBody SysUserDto sysUserDto) {
        boolean result = this.sysUsersService.create(sysUserDto);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed();
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    @Operation(summary = "更新用户")
    public CommonResult<Boolean> update(
            @Parameter(name = "id", description = "用户id", required = true) @PathVariable("id") Integer id,
            @Validated @RequestBody SysUserDto sysUserDto
    ) {
        boolean result = this.sysUsersService.update(id, sysUserDto);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    @Operation(summary = "删除用户")
    public CommonResult<Boolean> delete(@Parameter(name = "id", description = "用户id", required = true) @PathVariable Integer id) {
        boolean result = this.sysUsersService.delete(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed();
    }

}
