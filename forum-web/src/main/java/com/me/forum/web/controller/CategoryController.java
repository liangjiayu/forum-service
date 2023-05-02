package com.me.forum.web.controller;

import com.me.forum.common.api.CommonResult;
import com.me.forum.service.dto.CategoryDto;
import com.me.forum.service.dto.CategoryPageDto;
import com.me.forum.service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(CategoryPageDto categoryPageDto) {
        return CommonResult.success(this.categoryService.list(categoryPageDto));
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody @Valid CategoryDto categoryDto) {
        boolean result = this.categoryService.create(categoryDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody @Valid CategoryDto categoryDto) {
        categoryDto.setId(id);
        boolean result = this.categoryService.update(categoryDto);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") String id) {
        boolean result = this.categoryService.delete(id);
        if (result) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
