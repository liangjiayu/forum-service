package com.me.forum.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.common.api.ApiException;
import com.me.forum.dao.mapper.CategoryMapper;
import com.me.forum.dao.modal.Category;
import com.me.forum.service.dto.CategoryPageDto;
import com.me.forum.service.dto.CategoryDto;
import com.me.forum.service.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {


    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public IPage<Category> list(CategoryPageDto categoryPageDto) {
        Page<Category> page = new Page<>(categoryPageDto.getPageNum(), categoryPageDto.getPageSize());
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();

        return this.categoryMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean create(CategoryDto categoryDto) {
        // 检验 name 是否唯一
        QueryWrapper<Category> nameQuery = new QueryWrapper<>();
        nameQuery.eq("name", categoryDto.getName());
        if (this.categoryMapper.selectCount(nameQuery) > 0) {
            throw new ApiException("名称已存在");
        }
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        category.setId(null);

        return this.categoryMapper.insert(category) > 0;
    }

    @Override
    public boolean update(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);

        return this.categoryMapper.updateById(category) > 0;
    }

    @Override
    public boolean delete(String id) {
        return this.categoryMapper.deleteById(id) > 0;
    }
}
