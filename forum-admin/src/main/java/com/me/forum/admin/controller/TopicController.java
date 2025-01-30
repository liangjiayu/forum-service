package com.me.forum.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.admin.dto.TopicPageDto;
import com.me.forum.admin.model.Topic;
import com.me.forum.common.api.CommonResult;
import com.me.forum.admin.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    ITopicService topicService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(TopicPageDto topicPageDto) {
        IPage<Topic> records = this.topicService.list(topicPageDto);
        return CommonResult.success(records);
    }

}
