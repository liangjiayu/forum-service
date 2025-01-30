package com.me.forum.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.admin.dto.TopicDto;
import com.me.forum.admin.dto.TopicPageDto;
import com.me.forum.admin.model.Topic;
import com.me.forum.common.api.CommonResult;
import com.me.forum.admin.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/topic")
@Tag(name = "TopicController", description = "话题API")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "获取话题列表")
    public CommonResult<IPage<Topic>> list(@Validated @ParameterObject TopicPageDto topicPageDto) {
        IPage<Topic> records = this.topicService.list(topicPageDto);
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建话题")
    public CommonResult create(@Validated @RequestBody TopicDto topicDto) {
        boolean result = this.topicService.create(topicDto);
        if (result) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    @Operation(summary = "更新话题")
    public CommonResult update(
            @Parameter(name = "id", description = "话题id", required = true) @PathVariable("id") Integer id,
            @Validated @RequestBody TopicDto topicDto
    ) {
        topicDto.setId(id);
        boolean result = this.topicService.update(topicDto);
        if (result) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    @Operation(summary = "删除话题")
    public CommonResult delete(@Parameter(name = "id", description = "话题id", required = true) @PathVariable Integer id) {
        boolean result = this.topicService.delete(id);
        if (result) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @PostMapping("/searchByMid")
    @ResponseBody
    @Operation(summary = "查询用户的话题")
    public CommonResult searchByMid(@Parameter(name = "mid", description = "用户id", required = true) Integer mid) {
        List<Topic> records = this.topicService.searchByMid(mid);

        return CommonResult.success(records);
    }

}
