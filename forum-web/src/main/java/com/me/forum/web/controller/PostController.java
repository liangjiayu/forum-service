package com.me.forum.web.controller;

import com.me.forum.common.api.CommonResult;
import com.me.forum.service.dto.PostDto;
import com.me.forum.service.dto.PostPageDto;
import com.me.forum.service.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    IPostService postService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(PostPageDto postPageDto) {
        return CommonResult.success(this.postService.list(postPageDto));
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody @Valid PostDto postDto) {
        boolean result = this.postService.create(postDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody @Valid PostDto postDto) {
        postDto.setId(id);
        boolean result = this.postService.update(postDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") String id) {
        boolean result = this.postService.delete(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
