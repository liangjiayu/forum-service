package com.me.forum.web.controller;

import com.me.forum.common.api.CommonResult;
import com.me.forum.service.dto.TagDto;
import com.me.forum.service.dto.TagPageDto;
import com.me.forum.service.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    ITagService tagService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(TagPageDto tagPageDto) {
        return CommonResult.success(this.tagService.list(tagPageDto));
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody @Valid TagDto tagDto) {
        boolean result = this.tagService.create(tagDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody @Valid TagDto tagDto) {
        tagDto.setId(id);
        boolean result = this.tagService.update(tagDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") String id) {
        boolean result = this.tagService.delete(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
