package com.me.forum.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.dao.modal.Category;
import com.me.forum.service.dto.CategoryDto;
import com.me.forum.service.dto.CategoryPageDto;

public interface ICategoryService {
    IPage<Category> list(CategoryPageDto categoryPageDto);

    boolean create(CategoryDto categoryDto);

    boolean update(CategoryDto categoryDto);

    boolean delete(String id);
}
