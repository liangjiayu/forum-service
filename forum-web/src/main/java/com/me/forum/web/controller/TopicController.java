package com.me.forum.web.controller;

import com.me.forum.common.api.CommonResult;
import com.me.forum.service.dto.TopicDto;
import com.me.forum.service.dto.TopicPageDto;
import com.me.forum.service.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    ITopicService topicService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(TopicPageDto topicPageDto) {
        return CommonResult.success(this.topicService.list(topicPageDto));
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody @Valid TopicDto topicDto) {
        boolean result = this.topicService.create(topicDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody @Valid TopicDto topicDto) {
        topicDto.setId(id);
        boolean result = this.topicService.update(topicDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") String id) {
        boolean result = this.topicService.delete(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
